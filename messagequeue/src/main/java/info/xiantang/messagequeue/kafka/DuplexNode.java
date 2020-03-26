package info.xiantang.messagequeue.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class DuplexNode {

    private String SENT_TOPIC;
    private Producer producer;
    private Consumer<String, String> consumer;
    private String name;
    private String RECEIVE_TOPIC;

    DuplexNode(String SENT_TOPIC, String RECEIVE_TOPIC, Producer producer, Consumer<String, String> consumer, String name) {
        this.SENT_TOPIC = SENT_TOPIC;
        this.RECEIVE_TOPIC = RECEIVE_TOPIC;
        this.producer = producer;
        this.consumer = consumer;
        this.name = name;

    }

    void send(TcpPackage tcpPackage) {
        String jsonString = JSON.toJSONString(tcpPackage);
        ProducerRecord<String, String> records = new ProducerRecord<>(SENT_TOPIC, jsonString);
        producer.send(records, (record, e) ->
                System.out.println(name + "send topic:" + record.topic()
                        + " partition:" + record.partition()
                        + " offset:" + record.offset()
                        + " value:" + jsonString
                ));
    }

    void await() {
        List<String> list = new ArrayList<>();
        list.add(RECEIVE_TOPIC);
        consumer.subscribe(list);
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> element : records) {
                    handler(element);
                }
            }
        }).start();
    }

    protected abstract void handler(ConsumerRecord<String, String> element);
}
