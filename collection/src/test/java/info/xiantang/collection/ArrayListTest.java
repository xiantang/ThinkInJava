package info.xiantang.collection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ArrayListTest {


    static int getCapacity(ArrayList<?> l) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        return ((Object[]) dataField.get(l)).length;
    }
    @Test
    public void testInitSize() throws Exception {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        assertEquals(10, getCapacity(objects));
    }


    @Test
    public void testGrowing() throws Exception {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            objects.add(1);
        }
        assertEquals(15, getCapacity(objects));
    }


    @Test
    public void testModAndWith() {
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            int i1 = 6666 % 16;
            assertEquals(10, i1);
        }
        long l = System.currentTimeMillis() - currentTimeMillis;
        System.out.println("使用%时间: " + l);
        long currentTimeMillis1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            int i1 = 6666 & (16-1);
            assertEquals(10, i1);
        }
        long l1 = System.currentTimeMillis() - currentTimeMillis1;
        System.out.println("使用&时间: " + l1);

    }
}
