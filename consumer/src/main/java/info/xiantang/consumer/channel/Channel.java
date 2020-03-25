package info.xiantang.consumer.channel;

import info.xiantang.consumer.event.MessageEvent;

public interface Channel {
    void send(MessageEvent event);

    String getName();

}
