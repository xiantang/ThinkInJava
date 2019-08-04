package algorithm.offer2;

import algorithm.offer1.Node;

import java.util.LinkedList;
import java.util.List;

public class No13 {
    /**
     * 给定单向链表的头指针和一个结点指针， 定义一个函数在 O（1）时间删除该节点
     * 将当前要删除的对象的next 和data 设置为下一个对象的属性
     * 但是对于尾部和头部需要特殊处理
     */



    public static void main(String[] args) {
        Node node1=new Node("A");
        Node node2=new Node("B");
        Node node3=new Node("C");
        Node node4=new Node("D");

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.push(2);
        System.out.println(linkedList.pop());;
        System.out.println(linkedList.poll());


//        node1.setNext(node2);
//        node2.setNext(node3);
//        node3.setNext(node4);
//
//        delete(node1, node4);
//        Node temp = node1;
//        while(temp!=null){
//            System.out.println(temp.getData());
//            temp=temp.getNext();
//        }
    }

    private static void delete(Node head, Node node) {
        if (head == node) {
            head = null;
        } else if (node.getNext() == null) {
            while (head.getNext().getNext() != null) {
                head = head.getNext();
            }
            head.setNext(null);
        } else {
            node.setData(node.getNext().getData());
            node.setNext(node.getNext().getNext());
        }

    }
}
