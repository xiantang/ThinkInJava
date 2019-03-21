package c07;

public class Wind extends Instrument {

    public void play(Note n) {
        System.out.println("Wind.play()"+n);
    }

    @Override
    String what() {
        return "Wind";
    }

    @Override
    void adjust() {

    }
}

class Percussion extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Percussion.play()" + n);
    }
    @Override
    String what() {
        return "Percussion";
    }

    @Override
    void adjust() {

    }
}
