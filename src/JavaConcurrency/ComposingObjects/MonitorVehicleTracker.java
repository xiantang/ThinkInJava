package JavaConcurrency.ComposingObjects;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class MutablePoint {
    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}
public class MonitorVehicleTracker {
    private final Map<String, MutablePoint> locations;

    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = locations;
    }

    public Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    private Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result =
                new HashMap<String, MutablePoint>();
        for (String id :
                m.keySet()) {
            result.put(id, new MutablePoint(m.get(id)));
        }
        // 产生一个只读的map
        return Collections.unmodifiableMap(result);
    }
}
