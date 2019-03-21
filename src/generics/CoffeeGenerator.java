package generics;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Consumer;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] typs = {
            Leet.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class
    };
    private static Random rand = new Random(47);

    public CoffeeGenerator() {
    }

    private int size = 0;

    public CoffeeGenerator(int size) {
        this.size = size;
    }


    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) typs[rand.nextInt(typs.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        for (Coffee c:new CoffeeGenerator(5)
             ) {
            System.out.println(c);
        }
    }


}
