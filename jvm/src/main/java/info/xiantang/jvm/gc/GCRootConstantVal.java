package info.xiantang.jvm.gc;

public class GCRootConstantVal {
    private static int _10MB = 10 * 1024 * 1024;
    private static final GCRootConstantVal t = new GCRootConstantVal(8 * _10MB);
    private byte[] memory;

    public GCRootConstantVal(int size) {
        memory = new byte[size];
    }


    public static void main(String[] args) {
        GCRootConstantVal gcRootConstantVal = new GCRootConstantVal(4 * _10MB);
        gcRootConstantVal = null;
        System.gc();
    }



}
