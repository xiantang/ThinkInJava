package info.xiantang.collection.list;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class SkipListMapDemo {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer,String> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put(1, "php");
        skipListMap.put(2, "java");
        skipListMap.put(10, "python");
        skipListMap.put(15, "scala");
        // 左开右闭
        ConcurrentNavigableMap<Integer, String> subMap = skipListMap.subMap(2, 15);
        // java
        System.out.println(subMap.get(2));
        // python
        System.out.println(subMap.get(10));
        // null
        System.out.println(subMap.get(15));

    }

}
