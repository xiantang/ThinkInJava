package info.xiantang.designpattern.singleton;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: xiantang
 * @Date: 2019/4/29 9:16
 */
public class Pool {

    class Connection {

    }

    private static Pool instance = null;
    private List<Connection> connections;
    public Pool(int num) {
        connections = new LinkedList<Connection>();
        for (int i = 0; i < num; i++) {
            connections.add(new Connection());
        }
    }

    public static Pool getInstance(int num) {
        if (instance == null) {
            synchronized (Pool.class) {
                if (instance == null) {
                    instance = new Pool(num);
                }
            }
        }
        return instance;
    }
}
