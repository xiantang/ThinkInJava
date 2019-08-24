package concurrency.CancellationAndShutdown;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReaderThread extends Thread {
    private final Socket socket;
    private final InputStream in;


    public ReaderThread(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    public void interrupt() {
        try {
            socket.close();
        } catch (IOException e) {

        }
        finally {
            super.interrupt();
        }
    }

    @Override
    public void run() {
        byte[] buf = new byte[1024];
        while (true) {
            try {
                int count = in.read();
                if (count < 0) {
                    break;

                } else if (count > 0) {
                    System.out.println("process`");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
