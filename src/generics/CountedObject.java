package generics;

public class CountedObject {
    private static long counter = 0;
    private final long id = counter += 1;

    public long id() {
        return id;
    }

    @Override
    public String toString() {
        return "CountedObject" + id;
    }

    public static void main(String[] args) {
        Generator<CountedObject> gen =
                BasicGenerator.create(CountedObject.class);
        for (int i = 0; i <5 ; i++) {
            System.out.println(gen.next());
        }
    }
}
