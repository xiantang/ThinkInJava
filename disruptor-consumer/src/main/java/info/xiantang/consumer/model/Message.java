package info.xiantang.consumer.model;

public class Message {
    private String message;
    private String channelType;

    public Message(String message, String channelType) {
        this.message = message;
        this.channelType = channelType;
    }

    public String getMessage() {
        return message;
    }

    public String getChannelType() {
        return channelType;
    }

}
