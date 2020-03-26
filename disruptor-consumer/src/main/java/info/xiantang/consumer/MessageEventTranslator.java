package info.xiantang.consumer;

import com.lmax.disruptor.EventTranslatorOneArg;
import info.xiantang.consumer.event.MessageEvent;
import info.xiantang.consumer.model.Message;

public class MessageEventTranslator implements EventTranslatorOneArg<MessageEvent, Message> {
    @Override
    public void translateTo(MessageEvent messageEvent, long l, Message message) {
        messageEvent.setMessage(message.getMessage());
        messageEvent.setChannelType(message.getChannelType());
    }
}
