package JavaConcurrency.ThreadSafety;

import javax.servlet.*;
import java.math.BigInteger;

public class VolatileCachedFactorizer extends StatelessFactorizer implements Servlet {
    private volatile OneValueCache cache =
            new OneValueCache(null, null);
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)  {
        BigInteger i = extractFromRequest(servletRequest);
        BigInteger[] factors = cache.getLastFactory(i);
        if (factors == null) {
            factors = factor(i);
            cache = new OneValueCache(i, factors);
        }
        encodeIntoResponse(servletResponse, factors);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }


}
