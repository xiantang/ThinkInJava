package ThreadSafety;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

public class StatelessFactorizer implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse resp) {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        encodeIntoResponse(resp, factors);
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
