package ComposingObjects;

class Widget {
    void w() {

    }
}

public class PrivateLock {
    private final Object myLock = new Object();
    Widget widget;
    void someMethod() {
        synchronized (myLock) {
            widget.w();
        }
    }
}
