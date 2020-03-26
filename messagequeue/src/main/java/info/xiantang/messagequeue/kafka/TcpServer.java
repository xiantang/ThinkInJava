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

public class TcpServer extends DuplexNode {
    private int seq = new Random().nextInt(100);
    private static final String name = "TCP server ";
    private static final String SENT_TOPIC = "tcpFrom";
    private static final String RECEIVE_TOPIC = "tcpTo";

    TcpServer(Producer<String, String> producer, Consumer<String, String> consumer) {
        super(SENT_TOPIC,RECEIVE_TOPIC,producer,consumer,name);

    }

    void start() {
        await();
    }

    @Override
    public void handler(ConsumerRecord<String, String> record) {
        String value = record.value();
        TcpPackage tcpPackage = JSON.parseObject(value, TcpPackage.class);
        int syn = tcpPackage.getFlagSYN();
        int reSeq = tcpPackage.getSeq();
        if (syn == 1) {
            reSeq += 1;
            TcpPackage tcp = new TcpPackage(seq, 1, 1, reSeq,"1".getBytes());
            send(tcp);
        }
    }
}
