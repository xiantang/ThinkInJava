package info.xiantang.concurrency.PerformanceAndScalability;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Author: xiantang
 * @Date: 2019/4/22 14:45
 */
public class AttributeStore {
    private final Map<String, String>
            attributes = new HashMap<String, String>();

    public  boolean userLocationMatches(String name, String regexp) {
        String key = "users. " + name + ".location";
        String location;
        synchronized (this) {
             location = attributes.get(key);
        }

        if (location == null) {
            return false;
        } else {
            return Pattern.matches(regexp, location);
        }

    }
}
