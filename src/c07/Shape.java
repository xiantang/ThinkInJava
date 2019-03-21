package c07;

import java.util.Random;

public class Shape {
    void draw() {

    }

    void erase() {

    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    void erase() {
        System.out.println("Circle.erase()");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    void erase() {
        System.out.println("Square.erase");
    }

}
class Triangle extends Shape{
    @Override
    void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    void erase() {
        System.out.println("Triangle.erase()");
    }
}
class RandomShapeGenerator{
    private Random random = new Random();
    public Shape next(){
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }

    }

}
