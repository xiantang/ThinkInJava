package info.xiantang.concurrency.ComposingObjects;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class Point {
    public final int x, y;
    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }
}

public class DelegatingVehicleTracker {
    private final ConcurrentMap<String, Point> locations;
    private final Map<String, Point> unmodifiableMap;

    public DelegatingVehicleTracker(ConcurrentMap<String, Point> locations, Map<String, Point> unmodifiableMap) {
        this.locations = new ConcurrentHashMap<String, Point>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(unmodifiableMap);
    }

    public Map<String, Point> getLocations() {
        return unmodifiableMap;
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocations(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
    }


}
