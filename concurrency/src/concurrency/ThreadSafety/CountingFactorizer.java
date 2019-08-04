package concurrency.ThreadSafety;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class CountingFactorizer implements Servlet {
    private final AtomicInteger count = new AtomicInteger();

    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public AtomicInteger getCount() {
        return count;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        BigInteger i = extractFromRequest(servletRequest);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(servletResponse, factors);
    }
    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }
    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[] { i };
    }
    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }
    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
