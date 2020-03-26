package info.xiantang.jvm.dispatch;

/**
 * @Author: xiantang
 * @Date: 2019/8/28 10:10
 */
public class Dispatch {
    private static class QQ {

    }

    private static class _360 {

    }

    public static class Father {
        public void hardChoice(QQ arg){
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }
    public static class Son extends Father {
        public void hardChoice(QQ arg){
            System.out.println("son choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        
        // 方法的接收者和方法的参数统称为方法的宗量。
        // 根据静态类型和方法参数两个宗量判断
        // 所以为多分派
        // 静态 24: invokevirtual #8
        // Method jvm/dispatch/Dispatch$Father.hardChoice:(Ljvm/dispatch/Dispatch$_360;)V
        // Father.hardChoice(_360)
        father.hardChoice(new _360());
        // 静态 35: invokevirtual #11
        // Method jvm/dispatch/Dispatch$Father.hardChoice:(Ljvm/dispatch/Dispatch$QQ;)V
        // Father.hardChoice(QQ)
        son.hardChoice(new QQ());
        // 动态
        // 因为编译期已经决定了目标方法的签名必须是hardChoice(QQ) 所以不会关心参数的静态类型和实际类型
        // 只关注接收者 是Father 还是 Son

    }

}
