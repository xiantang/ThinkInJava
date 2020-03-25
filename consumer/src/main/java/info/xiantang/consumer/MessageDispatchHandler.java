package info.xiantang.consumer;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.lmax.disruptor.EventHandler;
import info.xiantang.consumer.channel.Channel;
import info.xiantang.consumer.event.MessageEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MessageDispatchHandler implements EventHandler<MessageEvent> {
    private Map<String, Channel> channelMapper;

    public MessageDispatchHandler() throws Exception {
        channelMapper = loadChannelMapper();
    }

    public Map<String, Channel> getChannelMapper() {
        return channelMapper;
    }

    public Map<String, Channel> loadChannelMapper() throws Exception{
        Map<String, Channel> channelMapper = new HashMap<>();
        String packagePath = "info.xiantang.consumer.channel.impl";
        ClassLoader classLoader = MessageDispatchHandler.class.getClassLoader();
        ImmutableSet<ClassPath.ClassInfo> topLevelClasses = ClassPath.from(classLoader).getTopLevelClasses(packagePath);
        List<? extends Class<?>> clazzs = topLevelClasses.stream().map(ClassPath.ClassInfo::load).filter(
                clzz -> Arrays.stream(clzz.getGenericInterfaces())
                        .anyMatch(in -> in.getTypeName().equals(Channel.class.getName()))
        ).collect(Collectors.toList());
        for (int i = 0; i < clazzs.size(); i++) {
            Class<? extends Channel> aClass = (Class<? extends Channel>) clazzs.get(i);
            Channel channel = aClass.newInstance();
            channelMapper.put(channel.getName(), channel);
        }
        return channelMapper;
    }

    @Override
    public void onEvent(MessageEvent messageEvent, long l, boolean b) {
        String channelType = messageEvent.getChannelType();
        Channel channel = channelMapper.get(channelType);
        channel.send(messageEvent);
    }
}
