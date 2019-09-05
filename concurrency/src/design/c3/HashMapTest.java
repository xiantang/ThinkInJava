package design.c3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: xiantang
 * @Date: 2019/9/5 11:02
 */
public class HashMapTest {
    public static void main(String[] args) {


        HashMap<String, String> stringStringHashMap = new HashMap<>(10000);
        stringStringHashMap.put("111", "222");
        stringStringHashMap.put("121", "222");

        Iterator<Map.Entry<String, String>> iterator = stringStringHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            entry.getKey();
            entry.getValue();
        }
    }
}
