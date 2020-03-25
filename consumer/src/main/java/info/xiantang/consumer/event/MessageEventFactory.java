package info.xiantang.consumer.event;

import com.lmax.disruptor.EventFactory;
import info.xiantang.consumer.event.MessageEvent;

public class MessageEventFactory implements EventFactory<MessageEvent> {
    @Override
    public MessageEvent newInstance() {
        return new MessageEvent();
    }
}
