package info.xiantang.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class LearnNIO {

    public static void copyFileUseNIO(String src,String dst) throws IOException {
        //声明源文件和目标文件
        FileInputStream fi=new FileInputStream(new File(src));
        FileOutputStream fo=new FileOutputStream(new File(dst));
        //获得传输通道channel
        FileChannel inChannel=fi.getChannel();
        FileChannel outChannel=fo.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true) {
            //判断是否读完文件
            int eof = inChannel.read(buffer);
            if (eof == -1) {
                break;
            }
            //重设一下buffer的position=0，limit=position
    //            public Buffer flip() {
    //                limit = position;
    //                position = 0;
    //                mark = -1;
    //                return this;
    //            }
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();
        fi.close();
        fo.close();
    }
    public static void main(String[] args) throws IOException {
//        // 获取通道
//        FileInputStream fin = new FileInputStream("src/readandshow.txt");
//        FileChannel fc = fin.getChannel();
//        // 创建缓冲区
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        // 将数据从通道读到缓冲区
//        fc.read(buffer);
//        FileOutputStream fout = new FileOutputStream("src/writesomebytes.txt");
//        for (int i=0; i<message.length; ++i) {
//            buffer.put( message[i] );
//        }
        LearnNIO.copyFileUseNIO("src/readandshow.txt","src/writesomebytes.txt");
    }
}
