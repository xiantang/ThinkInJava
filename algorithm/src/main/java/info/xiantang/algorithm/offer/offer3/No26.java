package info.xiantang.algorithm.offer.offer3;

import java.util.HashMap;
import java.util.Map;

public class No26 {
    /**
     * 请实现函数 ComplexListNode* Clone(ComplexListNode* pHead)，
     * 复制一个复杂链表。在复杂链表中，
     * 每个结点除了有一个 m_pNext 指针指向下一个结点外，
     * 还有一个 m_pSibling 指向链表中的任意结点或者 NULL
     */
    // TODO 非常经典的一道题 复制一个图
    public static void main(String[] args) {
        ComplexListNode node1=new ComplexListNode(1);
        ComplexListNode node2=new ComplexListNode(2);
        ComplexListNode node3=new ComplexListNode(3);
        ComplexListNode node4=new ComplexListNode(4);
        ComplexListNode node5=new ComplexListNode(5);
        node1.next=node2;node2.next=node3;node3.next=node4;
        node4.next=node5;node1.sibling=node3;node2.sibling=node5;
        node5.sibling = node2;
        node4.sibling=node2;
        ComplexListNode result=clone(node1);
        while(result!=null){
            System.out.println(result.data);
            result=result.next;
        }
    }

    private static Map<ComplexListNode, ComplexListNode> map = new HashMap<>();

    private static ComplexListNode clone(ComplexListNode node) {
        if (node == null) {
            return null;
        }
        ComplexListNode newNode;
        // 如果map中找不到这个对象
        // 就先new 对象出来 放到map中
        // 深度优先遍历这个对象的next 和 sibling
        // 也就是都是遇到就创建
        if (map.get(node) == null) {
            newNode = new ComplexListNode(node.data);
            map.put(node, newNode);
            map.get(node).next = clone(node.next);
            map.get(node).sibling = clone(node.sibling);

        } else {
            return map.get(node);
        }

        return newNode;
    }
}
