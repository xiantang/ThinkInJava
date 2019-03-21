package hape;


import com.xiantang.mypackage.A;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Line extends Shape {
    public Line(int i) {
//        List
        super(i);
//        Queue
//        LinkedList
        BlockingQueue<A> b = new LinkedBlockingDeque<>();
    }

}
