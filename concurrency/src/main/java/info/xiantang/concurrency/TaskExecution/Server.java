package info.xiantang.concurrency.TaskExecution;

import java.io.IOException;
import java.net.Socket;

public interface Server {
    public void start() throws IOException;

    public void handleRequest(Socket connection);
}
