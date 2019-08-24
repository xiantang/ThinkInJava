package concurrency.ComposingObjects;

import java.util.*;

public class PersonSet {
    private final Set<Person> mySet = new HashSet<Person>();

    public synchronized void addPerson(Person person) {
        mySet.add(person);
    }

    public synchronized boolean containPerson(Person person) {

        return mySet.contains(person);
    }

    public static void main(String[] args) {
        Collections.synchronizedMap(new HashMap<Person,Person>());
    }
}
