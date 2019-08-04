package algorithm.offer3;

import algorithm.offer2.BinaryTreeNode;

public class No19 {
    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像
     */
    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(10);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(9);
        BinaryTreeNode node7 = new BinaryTreeNode(11);
        node1.setLchild(node2);node1.setRchild(node3);
        node2.setLchild(node4);node2.setRchild(node5);
        node3.setLchild(node6);node3.setRchild(node7);
        print(node1);
        mirror(node1);
        print(node1);

    }
    private static void print(BinaryTreeNode root) {
        if(root!=null){
            System.out.println(root.getData());
            print(root.getLchild());
            print(root.getRchild());
        }
    }
    private static void mirror(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode tmp = root.getLchild();
        root.setLchild(root.getRchild());
        root.setRchild(tmp);
        mirror(root.getLchild());
        mirror(root.getRchild());

    }
}
