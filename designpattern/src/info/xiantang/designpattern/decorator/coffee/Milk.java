package info.xiantang.designpattern.decorator.coffee;

public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
        super.setDescription("Milk");
        super.setPrice(4.0f);
    }
}
