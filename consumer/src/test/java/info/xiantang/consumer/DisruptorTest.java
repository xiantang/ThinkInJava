package info.xiantang.consumer;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import info.xiantang.consumer.channel.Channel;
import info.xiantang.consumer.event.MessageEvent;
import info.xiantang.consumer.event.MessageEventFactory;
import info.xiantang.consumer.handler.MessageEventHandler;
import info.xiantang.consumer.handler.MessageExceptionHandler;
import info.xiantang.junitx.PrintTest;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class DisruptorTest extends PrintTest {
    private static final int ringBufferSize = 1024;

    @Test
    public void testDisruptor() throws InterruptedException {
        Disruptor<MessageEvent> disruptor = new Disruptor<>(new MessageEventFactory(), ringBufferSize, new MessageThreadFactory());
        disruptor.handleEventsWith(new MessageEventHandler(1)).then(new MessageEventHandler(4));
        disruptor.setDefaultExceptionHandler(new MessageExceptionHandler<>());
        RingBuffer<MessageEvent> ringBuffer = disruptor.start();
        MessageEventProducer producer = new MessageEventProducer(ringBuffer);
        producer.onData(new Message("Hello Disruptor", "java"));
        TimeUnit.MILLISECONDS.sleep(20);
        assertEquals("1\n4\n", getOutContent());
    }


    @Test
    public void testMessageDispatchHandler() throws Exception {
        MessageDispatchHandler handler = new MessageDispatchHandler();
        Map<String, Channel> mapper = handler.getChannelMapper();
        assertEquals(2, mapper.size());
    }


    @Test
    public void testDispatchChannel() throws Exception {
        Disruptor<MessageEvent> disruptor = new Disruptor<>(new MessageEventFactory(), ringBufferSize, new MessageThreadFactory());
        disruptor.handleEventsWith(new MessageDispatchHandler());
        RingBuffer<MessageEvent> ringBuffer = disruptor.start();
        MessageEventProducer producer = new MessageEventProducer(ringBuffer);
        Message message = new Message("hello Java", "java");
        Message python = new Message("hello Python", "python");
        producer.onData(message);
        producer.onData(python);
        TimeUnit.MILLISECONDS.sleep(20);
        assertEquals("hello Java\nhello Python\n", getOutContent());

    }

}
