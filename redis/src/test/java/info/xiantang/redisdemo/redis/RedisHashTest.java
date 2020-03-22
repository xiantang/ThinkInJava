package info.xiantang.redisdemo.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Map;

public class RedisHashTest {

    /**
     * hset 比较适合存储用户的属性，因为对于用户数据的修改比较方便
     */
    @Test
    public void testRedisHashCanPutUserInfo() {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.hset("xiantang", "age", "23");
        jedis.hset("xiantang", "name", "xiantang");
        Map<String, String> xiantang = jedis.hgetAll("xiantang");
        Iterator<Map.Entry<String, String>> iterator = xiantang.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }
        Iterator<Map.Entry<String, String>> iterator2 = jedis.hgetAll("xiantang").entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, String> next = iterator2.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }

    }


}
