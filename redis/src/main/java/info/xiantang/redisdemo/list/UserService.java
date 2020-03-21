package info.xiantang.redisdemo.list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class UserService {


    @Autowired
    private RedisTemplate redisTemplate;

    public Long addUser() {
        return redisTemplate.opsForList().leftPush("users", "test");

    }


    public String index(Integer start, Integer end) {
        List users = redisTemplate.opsForList().range("users", start, end);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < users.size(); i++) {
            Object user = users.get(i);
            sb.append(user).append(" ");
        }
        return sb.toString();
    }

    public boolean addUserWithRank(String name, Integer rank) {
        Set<ZSetOperations.TypedTuple<String>> usk = redisTemplate.opsForZSet().rangeWithScores("usk", 0, 4);
        Iterator iterator = usk.iterator();
        while (iterator.hasNext()) {
            ZSetOperations.TypedTuple<String> next = (ZSetOperations.TypedTuple<String>) iterator.next();
            System.out.println(next.getScore());
            System.out.println(next.getValue());
            System.out.println("-------");
        }

        return redisTemplate.opsForZSet().add("usk", name, rank);

    }
}
