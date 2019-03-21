package c07;

public class Note {
    private String noteName;

    public Note(String noteName) {
        // 因为wind 继承自instrument 所以instrument的接口一定定义在wind中
        this.noteName = noteName;
    }

    @Override
    public String toString() {

        return noteName;
    }

    public static final Note
            MIDDLE_C = new Note("Middle C"),
            C_SHARP = new Note("C Sharp"),
            B_FLAT = new Note("B Flat");
}
