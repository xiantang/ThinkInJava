package info.xiantang.jvm.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiantang
 * @Date: 2019/8/28 13:30
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没？");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));

        // 泛型擦除后
        //        Map<String, String> map = new HashMap();
        //        map.put("hello", "你好");
        //        map.put("how are you?", "吃了没？");
        //        System.out.println((String)map.get("hello"));
        //        System.out.println((String)map.get("how are you?"));

    }
}
