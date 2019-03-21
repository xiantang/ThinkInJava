package c11;

public class Cat {
    private int catNumber;

    public Cat(int catNumber) {
        this.catNumber = catNumber;
    }

    public void id() {
        System.out.println("Cat #" + catNumber);
    }
}
