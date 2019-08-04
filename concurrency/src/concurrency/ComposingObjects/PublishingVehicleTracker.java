package concurrency.ComposingObjects;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


class SafePoint {
    private int x, y;
    public SafePoint(int[] a) {
        this.x = a[0];
        this.y = a[1];
    }
    public SafePoint(SafePoint p) {
        this(p.get());
    }

    private int[] get() {
        return new int[]{x, y};
    }

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
// 将安全性委托给ConcurrentHashMap
public class PublishingVehicleTracker {
    private final Map<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<String, SafePoint>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocations(String id, int x, int y) {
        if (!locations.containsKey(id)) {
            throw new IllegalArgumentException(
                    "invalid vehicle name: " + id
            );

        }
        locations.get(id).set(x, y);
    }
}
