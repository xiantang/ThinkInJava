package offer.offer3;

import offer.offer2.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class No23 {
    /**
     * 从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印
     */
    public static void main(String[] args) {
        BinaryTreeNode node1=new BinaryTreeNode(8);
        BinaryTreeNode node2=new BinaryTreeNode(6);
        BinaryTreeNode node3=new BinaryTreeNode(10);
        BinaryTreeNode node4=new BinaryTreeNode(5);
        BinaryTreeNode node5=new BinaryTreeNode(7);
        BinaryTreeNode node6=new BinaryTreeNode(9);
        BinaryTreeNode node7=new BinaryTreeNode(11);
        node1.setLchild(node2);node1.setRchild(node3);
        node2.setLchild(node4);node2.setRchild(node5);
        node3.setLchild(node6);node3.setRchild(node7);
        printFromTopToBottom(node1);
    }

    private static void printFromTopToBottom(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
//            BinaryTreeNode binaryTreeNode = queue.poll();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode poll = queue.poll();
                System.out.print(poll.getData() + " ");
                if (poll.getLchild() != null) {
                    queue.add(poll.getLchild());
                }
                if (poll.getRchild() != null) {
                    queue.add(poll.getRchild());
                }
            }
            System.out.println("");
        }

    }
}
