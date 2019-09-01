package offer.offer3;

import offer.offer2.BinaryTreeNode;

public class No25 {
    /**
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     *      10
     *    5    12
     * 4     7
     */
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(12);
        root.setLchild(node1);
        root.setRchild(node4);
        node1.setLchild(node2);
        node1.setRchild(node3);
        findPath(root, 22,"");
    }

    private static String findPath(BinaryTreeNode root, int target, String pre) {
        if (root == null) {
            return "";
        }

        if (target == root.getData()) {
            System.out.println( pre + "->" + root.getData());
            return "";
        }
        if (root.getData() > target) {
            return "";
        }
        if (root.getData() < target) {
            pre += "->" + root.getData();
            target -= root.getData();
        }
        findPath(root.getLchild(), target, pre);
        findPath(root.getRchild(), target, pre);
        return "";
    }
}
