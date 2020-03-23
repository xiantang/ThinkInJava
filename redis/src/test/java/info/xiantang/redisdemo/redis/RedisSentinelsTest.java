package info.xiantang.redisdemo.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class RedisSentinelsTest {

    @Test
    public void testSentinels() {
        Set<String> sentinels = new HashSet<>();
        sentinels.add("192.168.123.136:26379");
        sentinels.add("192.168.123.136:26380");
        sentinels.add("192.168.123.136:26381");

        JedisSentinelPool pool = new JedisSentinelPool("mymaster", sentinels);
        Jedis resource = pool.getResource();
        Long hset = resource.hset("xiantang", "a", "a");

    }
}
