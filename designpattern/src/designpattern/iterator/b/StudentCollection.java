package designpattern.iterator.b;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: xiantang
 * @Date: 2019/5/8 22:31
 */
public class StudentCollection {
    private Queue<Student> queue;

    public StudentCollection() {
        this.queue = new PriorityQueue<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

    }

    public void add(Student student) {
        queue.add(student);
    }

    public Iterator<Student> getIterator() {
        return queue.iterator();
    }

    public static void main(String[] args) {
        StudentCollection sc = new StudentCollection();
        sc.add(new Student(22, "xt"));
        sc.add(new Student(12, "x1t"));
        sc.add(new Student(11, "1t"));
        Iterator<Student> iterator = sc.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getAge());
            iterator.remove();

        }
    }
}
