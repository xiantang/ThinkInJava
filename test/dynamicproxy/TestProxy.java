package dynamicproxy;

import org.junit.Test;

public class TestProxy {
    @Test
    public void test() {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookProxy.addBook();

    }
}
