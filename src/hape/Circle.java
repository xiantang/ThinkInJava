package hape;

import c07.Orc;

public class Circle extends Shape {
    public Circle(int i) {
        super(i);
        System.out.println("Drawing Circle");
    }
    void dispose(){
        System.out.println("Erasing Circle");
        super.dispose();

    }
}
