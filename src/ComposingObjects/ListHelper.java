package ComposingObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListHelper<E> {
    public List<E> list =
            Collections.synchronizedList(new ArrayList<E>());

//    public boolean putIfAbsent(E x) {
//        synchronized (list) {
//            boolean absent = !list.contains(x);
//            if (absent) list.add(x);
//            return absent;
//        }
//    }
    // 不是原子性的
    public synchronized boolean putIfAbsent(E x) { // 这个方法并不是线程安全的，因为当前只获得了ListHelp的锁，并没有获得list的锁，没有办法保证当前操作的原子性
        boolean absent = !list.contains(x); // 这里没有加锁 如果其他地方改变这个对象 如果absent改变 就会影响后面的操作！！
        if (absent) {
            list.add(x);
        }
        return absent;
    }


}
