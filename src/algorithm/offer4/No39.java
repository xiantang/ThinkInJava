package algorithm.offer4;

import algorithm.offer2.BinaryTreeNode;

/**
 * @Author: xiantang
 * @Date: 2019/7/30 23:44
 */
public class No39 {

    public static void main(String[] args) {
        BinaryTreeNode node1=new BinaryTreeNode(8);
        BinaryTreeNode node2=new BinaryTreeNode(8);
        BinaryTreeNode node3=new BinaryTreeNode(7);
        BinaryTreeNode node4=new BinaryTreeNode(9);
        BinaryTreeNode node5=new BinaryTreeNode(2);
        BinaryTreeNode node6=new BinaryTreeNode(4);
        BinaryTreeNode node7=new BinaryTreeNode(7);
        node1.setLchild(node2);node1.setRchild(node3);
        node2.setLchild(node4);node2.setRchild(node5);
        node5.setLchild(node6);node5.setRchild(node7);
        BinaryTreeNode a=new BinaryTreeNode(8);
        BinaryTreeNode b=new BinaryTreeNode(9);
        BinaryTreeNode c=new BinaryTreeNode(2);
        a.setLchild(b);a.setRchild(c);
        System.out.println(treeDepth(node1));

    }

    private static int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.getRchild());
        int right = treeDepth(root.getLchild());
        return Math.max(left, right) + 1;
    }
}
