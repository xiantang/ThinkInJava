package info.xiantang.messagequeue.kafka;

import com.alibaba.fastjson.JSON;
import info.xiantang.junitx.PrintTest;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.junit.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TcpClientTest extends PrintTest {

    private Consumer<String, String> initConsumer(String topic) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", topic);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return new KafkaConsumer<>(props);
    }

    private Producer<String, String> initProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 3);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return new KafkaProducer<>(props);
    }

    @Test
    public void testConnect() throws InterruptedException {
        TcpClient tcpClient = new TcpClient(initProducer(),initConsumer("tcpFrom"));
        TcpServer tcpServer = new TcpServer(initProducer(),initConsumer("tcpTo"));
        tcpServer.start();
        TimeUnit.MILLISECONDS.sleep(200);
        tcpClient.start();
        tcpClient.connect();
        TimeUnit.SECONDS.sleep(1);
        String outContent = getOutContent();
        String[] contents = outContent.split("\n");
        assertTrue(Pattern.matches("TCP client send topic:tcpTo.*?", contents[0]));
        assertTrue(Pattern.matches("TCP server send topic:tcpFrom.*?", contents[1]));
        assertTrue(Pattern.matches("TCP client send topic:tcpTo.*?", contents[2]));

    }




    @Test
    public void testParse() {
        TcpPackage expect = new TcpPackage(20, 0, 1,0,"1".getBytes());
        String jsonString = JSON.toJSONString(expect);
        TcpPackage actual = JSON.parseObject(jsonString, TcpPackage.class);
        assertEquals(expect, actual);
    }

}
