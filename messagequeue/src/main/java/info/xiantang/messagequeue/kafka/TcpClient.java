package info.xiantang.messagequeue.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.Producer;

import java.util.Random;

class TcpClient extends DuplexNode {


    private int seq = new Random().nextInt(100);
    private static final String name = "TCP client ";
    private static final String SENT_TOPIC = "tcpTo";
    private static final String RECEIVE_TOPIC = "tcpFrom";


    TcpClient(Producer producer, Consumer<String, String> consumer) {
        super(SENT_TOPIC,RECEIVE_TOPIC,producer,consumer,name);
    }

    void connect() {
        TcpPackage tcpPackage = new TcpPackage(seq, 0, 1, 0,"1".getBytes());
        send(tcpPackage);
    }

    void start() {
        await();
    }

    @Override
     public void handler(ConsumerRecord<String, String> record) {
        String tcpPackage = record.value();
        TcpPackage tcp = JSON.parseObject(tcpPackage, TcpPackage.class);
        int flagACK = tcp.getFlagACK();
        int flagSYN = tcp.getFlagSYN();
        if (flagACK == 1 && flagSYN == 1) {
            seq += 1;
            TcpPackage returnPackage = new TcpPackage(this.seq, 1, 0, tcp.getSeq() + 1, "1".getBytes());
            send(returnPackage);
        }

    }
}
