package info.xiantang.messagequeue.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TcpServer {
    private final Producer<String, String> producer;
    private int seq = new Random().nextInt(100);

    private final Consumer<String, String> consumer;
    private static final String name = "TCP server ";


    public TcpServer(Producer<String, String> producer, Consumer<String, String> consumer) {

        this.producer = producer;
        this.consumer = consumer;

    }

    public void start() {
        ArrayList<String> topics = new ArrayList<>();
        topics.add("tcpTo");
        consumer.subscribe(topics);
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    handler(record);
                }
            }
        }).start();

    }

    private void handler(ConsumerRecord<String, String> record) {
        String value = record.value();
        TcpPackage tcpPackage = JSON.parseObject(value, TcpPackage.class);
        int syn = tcpPackage.getFlagSYN();
        int reSeq = tcpPackage.getSeq();

        if (syn == 1) {
            reSeq += 1;
            TcpPackage tcp = new TcpPackage(seq, 1, 1, reSeq,"1".getBytes());
            String jsonString = JSON.toJSONString(tcp);
            ProducerRecord<String, String> records = new ProducerRecord<>("tcpFrom", jsonString);
            producer.send(records, (send, e) ->
                    System.out.println(name + "send topic:" + send.topic()
                            + " partition:" + send.partition()
                            + " offset:" + send.offset()
                            + " value:" + jsonString
                    ));
        }

    }
}
