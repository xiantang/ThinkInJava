package EnumClass;

enum Activity{
    SITTING,LYING,STANDING,HOPPING
}

public class RandomTest {
    public static void main(String[] args) {
//        System.out.println();
        for (int i = 0; i <20 ; i++) {
            System.out.println(Enums.random(Activity.class)+"  ");

        }
    }
}
