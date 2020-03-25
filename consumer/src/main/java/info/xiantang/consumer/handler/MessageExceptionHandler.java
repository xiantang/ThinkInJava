package info.xiantang.consumer.handler;

import com.lmax.disruptor.ExceptionHandler;

public class MessageExceptionHandler<T> implements ExceptionHandler<T> {

    @Override
    public void handleEventException(Throwable throwable, long l, T t) {

    }

    @Override
    public void handleOnStartException(Throwable throwable) {

    }

    @Override
    public void handleOnShutdownException(Throwable throwable) {

    }
}
