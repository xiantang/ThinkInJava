package info.xiantang.algorithm.collection.find;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DictHtTest {


    @Test
    public void testPut() {
        Dict.DictHt<String, Integer> dictHt = new Dict.DictHt<>();
        dictHt.put("1", 123);
        int value = dictHt.get("1");
        assertEquals(value, 123);
    }

    @Test
    public void testWithAnother() {
        Dict.DictHt<String, Integer> dictHt = new Dict.DictHt<>();
        dictHt.put("1", 123);
        dictHt.put("1", 324);
        int value2 = dictHt.get("1");
        assertEquals(value2, 324);
    }

    @Test
    public void testInsertWillReplace() {
        Dict.DictHt<String, Integer> dictHt = new Dict.DictHt<>();
        dictHt.put("1", 123);
        dictHt.put("1", 324);
        int used = dictHt.getUseSize();
        assertEquals(1, used);
    }

    @Test
    public void testResizeCreateSubDict() {
        Dict<String, Integer> dictHt = new Dict<>(8, 0.75);
        dictHt.put("1", 123);
        dictHt.put("2", 324);
        dictHt.put("3", 324);
        dictHt.put("4", 324);
        dictHt.put("5", 324);
        dictHt.put("6", 324);
        dictHt.put("7", 324);
        dictHt.put("8", 324);
        dictHt.put("9", 324);
        int size = dictHt.getSize();
        assertEquals(size, 16);
    }

    @Test
    public void testResizeTreHashIndex() {
        Dict<String, Integer> dictHt = new Dict<>(8, 0.75);
        dictHt.put("1", 123);
        dictHt.put("2", 324);
        dictHt.put("3", 324);
        dictHt.put("4", 324);
        dictHt.put("5", 324);
        dictHt.put("6", 324);
        dictHt.put("7", 324);
        int index = dictHt.getTreHashIndex();
        assertEquals(0, index);
        dictHt.put("8", 324);
        dictHt.put("9", 324);
        dictHt.put("10", 324);
        dictHt.put("11", 324);
        int index1 = dictHt.getTreHashIndex();
        assertEquals(4, index1);
    }

    @Test
    public void testResizeTreHashPutComplete() {
        Dict<String, Integer> dictHt = new Dict<>(8, 0.75);
        dictHt.put("1", 123);
        dictHt.put("2", 324);
        dictHt.put("3", 324);
        dictHt.put("4", 324);
        dictHt.put("5", 324);
        dictHt.put("6", 324);
        dictHt.put("7", 324);
        dictHt.put("8", 324);
        dictHt.put("9", 324);
        dictHt.put("10", 324);
        dictHt.put("11", 324);
        dictHt.put("12", 324);
        dictHt.put("13", 324);
        dictHt.put("14", 324);
        dictHt.put("15", 324);
        int index1 = dictHt.getTreHashIndex();
        assertEquals( -1,index1);
    }


    @Test
    public void testResizeTreHashGetComplete() {
        Dict<String, Integer> dictHt = new Dict<>(8, 0.75);
        dictHt.put("1", 123);
        dictHt.put("2", 324);
        dictHt.put("3", 324);
        dictHt.put("4", 324);
        dictHt.put("5", 324);
        dictHt.put("6", 324);
        dictHt.put("7", 321);
        dictHt.get("2");
        dictHt.get("3");
        dictHt.get("4");
        dictHt.get("5");
        dictHt.put("8", 211);
        int v1 = dictHt.get("1");
        assertEquals(123, v1);
        int v2 = dictHt.get("7");
        assertEquals(321, v2);
        int v3 = dictHt.get("8");
        assertEquals(211, v3);
        int index = dictHt.getTreHashIndex();
        assertEquals(-1, index);
    }


}
