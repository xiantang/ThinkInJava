package EnumClass;
enum Sigin{
    GREEM,YELLOW,RED
}

public class TrafficLight {
    Sigin color = Sigin.RED;

    public void change() {
        switch (color){
            case RED:
                color = Sigin.GREEM;
                break;
            case GREEM:
                color = Sigin.YELLOW;
                break;
            case YELLOW:
                color = Sigin.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
