package c10;

import java.util.Random;

public class PetCount {
    private static Random rand = new Random();
    static String[] typenames = {
            "Pet", "Dog", "Pug", "Cat",
            "Rodent", "Gerbil", "Hamster",
    };

    // Exceptions thrown to console:
    public static void main(String[] args) {
        Object[] pets = new Object[15];

        Class[] petTypes = {
//                    Class.forName("c10.Dog"),
//                    Class.forName("c10.Pug"),
//                    Class.forName("c10.Cat"),
//                    Class.forName("c10.Rodent"),
//                    Class.forName("c10.Gerbil"),
//                    Class.forName("c10.Hamster"),
                Dog.class,
                Pug.class,
                Cat.class,
                Rodent.class,
                Gerbil.class,
                Hamster.class};


        try {
            for (int i = 0; i < pets.length; i++)
                pets[i] = petTypes[rand.nextInt(petTypes.length)]
                        .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        AssociativeArray map =
                new AssociativeArray(typenames.length);
        for (int i = 0; i < typenames.length; i++)
            map.put(typenames[i], new Counter());
//        for (int i = 0; i < pets.length; i++) {
//            Object o = pets[i];
//            if (o instanceof Pet)
//                ((Counter) map.get("Pet")).i++;
//            if (o instanceof Dog)
//                ((Counter) map.get("Dog")).i++;
//            if (o instanceof Pug)
//                ((Counter) map.get("Pug")).i++;
//            if (o instanceof Cat)
//                ((Counter) map.get("Cat")).i++;
//            if (o instanceof Rodent)
//                ((Counter) map.get("Rodent")).i++;
//            if (o instanceof Gerbil)
//                ((Counter) map.get("Gerbil")).i++;
//            if (o instanceof Hamster)
//                ((Counter) map.get("Hamster")).i++;
//            for (int j = 0; j < petTypes.length; j++) {
//                if (petTypes[j].isInstance(o)) {
//                    ((Counter) map.get(petTypes[j].toString())).i++;
//                }
//            }
//        }
//        // List each individual pet:
//        for (int i = 0; i < pets.length; i++)
//            System.out.println(pets[i].getClass());
//        // Show the counts:
//        System.out.println(map);
//    }
}
}