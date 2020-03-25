package info.xiantang.messagequeue.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TcpClient {


    private final Producer producer;
    private final Consumer<String, String> consumer;
    private int seq = new Random().nextInt(100);
    private static final String name = "TCP client ";



    public TcpClient(Producer producer, Consumer<String, String> consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    public void connect() {
        TcpPackage tcpPackage = new TcpPackage(seq, 0, 1, 0,"1".getBytes());
        String jsonString = JSON.toJSONString(tcpPackage);
        ProducerRecord<String, String> records = new ProducerRecord<>("tcpTo", jsonString);
        producer.send(records, (record, e) ->
                System.out.println(name + "send topic:" + record.topic()
                        + " partition:" + record.partition()
                        + " offset:" + record.offset()
                        + " value:" + jsonString
                ));

    }

    public void start() {
        List<String> list = new ArrayList<>();
        list.add("tcpFrom");
        consumer.subscribe(list);
        new Thread(() -> {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (ConsumerRecord<String, String> element : records) {
                    handler(element);
                }
            }
        }).start();
    }

    private void handler(ConsumerRecord<String, String> record) {
        String tcpPackage = record.value();
        TcpPackage tcp = JSON.parseObject(tcpPackage, TcpPackage.class);
        int flagACK = tcp.getFlagACK();
        int flagSYN = tcp.getFlagSYN();
        if (flagACK == 1 && flagSYN == 1) {
            seq += 1;
            TcpPackage returnPackage = new TcpPackage(this.seq, 1, 0, tcp.getSeq() + 1, "1".getBytes());
            String jsonString = JSON.toJSONString(returnPackage);
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
