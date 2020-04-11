package info.xiantang.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class StreamTest {


    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );


    /**
     * 1.看到上面的arr数组了吗，控制台输出数组每个数字的平方
     */
    @Test
    public void squareAllElementsOfArray() {
        int[] arr = {5, 3, 6, 10, 2, 7};
        int[] result = Arrays.stream(arr).map(x -> x * x).toArray();
        assertArrayEquals(new int[]{25, 9, 36, 100, 4, 49}, result);
    }


    /**
     * 3.有没有交易员是在米兰工作的？
     */
    @Test
    public void testHasTradersWorkInMilan() {
        Optional<Transaction> first = transactions.stream()
                .filter(x -> "Milan".equals(x.getTrader().getCity()))
                .findFirst();
        assertTrue(first.isPresent());
    }

    /**
     * 4.找出2011年所有交易 并按照交易额排序（低->高）?
     */
    @Test
    public void testSortAltransactionsIn2011byVolume() {
        List<Transaction> list = transactions.stream()
                .filter(x -> 2011 == x.getYear())
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        List<Transaction> tmp = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2011, 400)
        );
        List<Transaction> expect = new ArrayList<>(tmp);

        assertEquals(expect, list);
    }


    /**
     * 5.交易员都在哪些不同城市工作过?
     */
    @Test
    public void testWorkCityList() {
        List<String> actual = transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct().collect(Collectors.toList());
        ArrayList<String> expect = new ArrayList<>();
        expect.add("Cambridge");
        expect.add("Milan");
        assertEquals(expect, actual);
    }


    /**
     * 6.查找出来自剑桥的交易员，并按姓名排序?
     */
    @Test
    public void testFindCambridgeTradersSortByName() {
        List<Trader> actual = transactions.stream()
                .filter(x -> "Cambridge".equals(x.getTrader().getCity()))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        List<Trader> expect = new ArrayList<>();
        expect.add(alan);
        expect.add(brian);
        expect.add(raoul);
        assertEquals(expect, actual);
    }


    /**
     * 7.打印生活在剑桥的交易员的所有交易额
     */
    @Test
    public void testListAllAltransactionsOfCambridge() {
        List<Integer> actual = transactions.stream()
                .filter(x -> "Cambridge".equals(x.getTrader().getCity()))
                .map(Transaction::getValue)
                .collect(Collectors.toList());

        List<Integer> expect = new ArrayList<>();
        expect.add(300);
        expect.add(1000);
        expect.add(400);
        expect.add(950);

        assertEquals(expect, actual);
    }


    /**
     * 8.返回所有交易员姓名的字符串，并按字母顺序排序打印
     */
    @Test
    public void testReturnAllTraderNameAndSortByName() {
        List<Trader> actual = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        List<Trader> expect = new ArrayList<>();
        expect.add(alan);
        expect.add(brian);
        expect.add(mario);
        expect.add(raoul);
        assertEquals(expect, actual);
    }

    /**
     * 9.所有交易中，最高的交易额是多少
     */
    @Test
    public void testFindTopAltransactions() {
        Optional<Integer> mayBeMax = transactions.stream()
                .map(Transaction::getValue).max(Comparator.comparing(Integer::intValue));
        assertEquals(Optional.of(1000), mayBeMax);

    }

    /**
     * 10.找到交易额最小的交易
     */
    @Test
    public void testFindMinTransaction() {
        Optional<Transaction> actual = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        assertEquals(Optional.of(new Transaction(brian, 2011, 300)), actual);
    }
}
