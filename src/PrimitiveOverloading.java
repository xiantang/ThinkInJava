public class PrimitiveOverloading {
    void  f1 (short x){
        System.out.println("f1 (short x)");
    }

    public static void main(String[] args) {
        PrimitiveOverloading primitiveOverloading = new PrimitiveOverloading();
        int a = 111;
        primitiveOverloading.f1((short) a);
    }


}
