package info.xiantang.collection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class HashMapTest {
    static int getCapacity(HashMap<?,?> l) throws Exception {
        Field dataField = HashMap.class.getDeclaredField("threshold");
        dataField.setAccessible(true);
        return (int)dataField.get(l);
    }

    @Test
    public void testHashMapInitCapacity() throws Exception {
        HashMap<Object, Object> hashMap = new HashMap<>();

        hashMap.put(1, 1);
        int v = (int) (getCapacity(hashMap) / 0.75);
        assertEquals(16, v);
    }

    @Test
    public void testHashMapResize() throws Exception {
        HashMap<Object, Object> hashMap = new HashMap<>();
        for (int i = 0; i < 13; i++) {
            hashMap.put(i, 1);
        }
        int v = (int) (getCapacity(hashMap) / 0.75);
        assertEquals(32, v);
    }


}
