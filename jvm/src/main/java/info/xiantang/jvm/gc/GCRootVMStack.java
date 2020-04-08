package info.xiantang.jvm.gc;

/**
 * -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 */
public class GCRootVMStack {

    private int _10MB = 10 * 1024 * 1024;
    private byte[] memory = new byte[8 * _10MB];


    public static void firstGC() {
        GCRootVMStack gcRootVMStack = new GCRootVMStack();
        System.gc();
        System.out.println("第一次 GC 完成");
    }

    public static void secondGC() {
        System.gc();
        System.out.println("第二次 GC 完成");
    }

    public static void main(String[] args) {
        GCRootVMStack.firstGC();
        GCRootVMStack.secondGC();

    }

}
