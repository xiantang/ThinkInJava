package info.xiantang.consumer.event;

public class MessageEvent {
    private String message;
    private String channelType;

    public String getMessage() {
        return message;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
