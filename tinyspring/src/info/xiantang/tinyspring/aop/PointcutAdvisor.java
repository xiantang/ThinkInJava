package info.xiantang.tinyspring.aop;

public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
