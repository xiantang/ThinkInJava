package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MultiPortEcho {
    private int ports[];
    private ByteBuffer echoBuffer = ByteBuffer.allocate(1024);
    public MultiPortEcho(int ports[]) throws IOException {
        this.ports = ports;
        go();
    }

    private void go() throws IOException {
        // 1. 创建一个selector，select是NIO中的核心对象
        Selector selector = Selector.open();
        // 为每个端口打开一个监听
        for (int i = 0; i < ports.length; i++) {
            // 打开ServerSocketChannel
            ServerSocketChannel ssc = ServerSocketChannel.open();
            // 非阻塞
            ssc.configureBlocking(false);
            ServerSocket ss = ssc.socket();
            InetSocketAddress address = new InetSocketAddress(ports[i]);
            ss.bind(address);// 监听端口
            // 注册到selector
            SelectionKey key = ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Going to listen on " + ports[i]);
        }//4. 开始循环，我们已经注册了一些IO兴趣事件
        while (true) {
            //这个方法会阻塞，直到至少有一个已注册的事件发生。当一个或者更多的事件发生时
            int num = selector.select();
            // 返回事件发生的集合
            Set selectKeys = selector.selectedKeys();
            // 迭代
            Iterator it = selectKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                // 调用readyOps方法 检查发送了什么类型的时间
                if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    SelectionKey newKey = sc.register(selector,SelectionKey.OP_READ);
                    it.remove();
                    System.out.println("Got connection from " + sc);

                }else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                    // Read the data
                    SocketChannel sc = (SocketChannel) key.channel();
                    // Echo data
                    int bytesEchoed = 0;
                    while (true) {
                        echoBuffer.clear();
                        int r = sc.read(echoBuffer);
                        if (r <= 0) {
                            break;
                        }
                        echoBuffer.flip();
                        sc.write(echoBuffer);
                        bytesEchoed += r;
                    }
                    System.out.println("Echoed " + bytesEchoed + " from " + sc);
                    it.remove();
                }

            }
        }

    }
    public static void main(String[] args) throws IOException {
        String arg[]={"9001","9002","9003"};
        int ports[] = new int[arg.length];
        for (int i = 0; i < arg.length; ++i) {
            ports[i] = Integer.parseInt(arg[i]);
        }
        new MultiPortEcho(ports);
    }

}
