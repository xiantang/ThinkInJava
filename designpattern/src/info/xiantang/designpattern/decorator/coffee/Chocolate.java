package info.xiantang.designpattern.decorator.coffee;

public class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        super.setDescription("Chocolate");
        super.setPrice(3.0f);
    }

    public static void main(String[] args) {
        Drink order;
        order = new Decaf();
        System.out.println(new Milk(new Chocolate(order)).getDescription());

    }
}
