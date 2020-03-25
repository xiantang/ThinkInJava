package info.xiantang.consumer;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import info.xiantang.consumer.event.MessageEvent;

public class MessageEventProducer {
    private RingBuffer<MessageEvent> ringBuffer;

    public MessageEventProducer(RingBuffer<MessageEvent> ringBuffer) {

        this.ringBuffer = ringBuffer;
    }

    public void onData(Message message) {
        EventTranslatorOneArg<MessageEvent,Message> translator = new MessageEventTranslator();
        ringBuffer.publishEvent(translator, message);
    }
}
