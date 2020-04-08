package info.xiantang.jvm.gc;

public class GCRootStaticVal {

    private static int _10MB = 10 * 1024 * 1024;
    private byte[] memory;
    private static GCRootStaticVal t;

    public GCRootStaticVal(int size) {
        memory = new byte[size];
    }


    public static void main(String[] args) {

        GCRootStaticVal t2 = new GCRootStaticVal(4 * _10MB);
        t2.t = new GCRootStaticVal(8 * _10MB);
        t2 = null;
        System.gc();
    }



}
