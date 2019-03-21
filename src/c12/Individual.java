package c12;

import java.util.Set;
import java.util.TreeSet;

public class Individual implements Comparable<Individual> {
    private static long count = 0;
    private final long id = count++;
    private String name;

    public Individual() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }

    public long id() {
        return id;
    }

    public Individual(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Individual &&
                id == ((Individual) obj).id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (name != null) {
            result = 37 * result + name.hashCode();
        }
        result = 37 * result + name.hashCode();
        return result;
    }

    @Override
    public int compareTo(Individual o) {
        String first = getClass().getSimpleName();
        String argFirst = o.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if (firstCompare != 0) {
            return firstCompare;
        }
        if (name != null && o.name != null) {
            int secondCompare = name.compareTo(o.name);
            if (secondCompare != 0) {
                return secondCompare;
            }
        }
        return (o.id < id ? -1 : (o.id == id ? 0 : 1));
    }

    public static void main(String[] args) {
        Set<Individual> pets = new TreeSet<>();

    }
}
