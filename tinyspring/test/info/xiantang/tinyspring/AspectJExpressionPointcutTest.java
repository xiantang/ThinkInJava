package info.xiantang.tinyspring;

import info.xiantang.tinyspring.hello.HelloWorldServiceImp;
import org.junit.Test;
import info.xiantang.tinyspring.aop.AspectJExpressionPointcut;

public class AspectJExpressionPointcutTest {
    @Test
    public void testClassFilter() {

    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* hello.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWorldServiceImp.class.getDeclaredMethod("helloWorld"), HelloWorldServiceImp.class);
        System.out.println(matches);
    }
}
