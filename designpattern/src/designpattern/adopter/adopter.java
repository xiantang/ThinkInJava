package designpattern.adopter;

/**
 * @Author: xiantang
 * @Date: 2019/4/29 11:19
 */
public class adopter implements Cat, Dog {
    Cat cat = null;
    Dog dog = null;

    public adopter(Cat cat) {
        this.cat = cat;
    }

    public adopter(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void catchM() {
        dog.bark();

    }

    @Override
    public void bark() {
        cat.catchM();
    }
}
