package info.xiantang.concurrency.TaskExecution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 81);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //向服务器端发送数据
        PrintStream out = new PrintStream(socket.getOutputStream());
        System.out.print("请输入: \t");
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        out.println(str);

    }
}
