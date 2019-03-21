public class WaterSource {
    private String s;
    WaterSource() {
        System.out.println("WaterSource()");
        s = new String("Constructed");
    }

    @Override
    public String toString() {
        return s;
    }
}
