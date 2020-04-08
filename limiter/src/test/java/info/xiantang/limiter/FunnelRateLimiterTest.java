package info.xiantang.limiter;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class FunnelRateLimiterTest {

    @Test
    public void testFunnelRateLimiter() throws InterruptedException {
        FunnelRateLimiter rateLimiter = new FunnelRateLimiter(100, 100.0  / 1000);
        TimeUnit.SECONDS.sleep(1);

        assertTrue(rateLimiter.isActionAllowed(10));




    }

}
