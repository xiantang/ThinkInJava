package info.xiantang.consumer.handler;

import com.lmax.disruptor.EventHandler;
import info.xiantang.consumer.event.MessageEvent;

public class MessageEventHandler implements EventHandler<MessageEvent> {
    private int count;

    public MessageEventHandler(int count) {
        this.count = count;
    }

    @Override

    public void onEvent(MessageEvent messageEvent, long l, boolean b) {
        System.out.println(count);
    }
}
