package c07;

import c07.Note;

public abstract class Instrument {
    public abstract void play(Note n);


    String what() {
        return "Instrument";
    }

    abstract void adjust();


}
