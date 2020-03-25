package info.xiantang.consumer;

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

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }
}
