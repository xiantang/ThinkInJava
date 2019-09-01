package offer.offer2;

public class No18 {
    /**
     * 输入两颗二叉树 A 和 B，判断 B 是不是 A 的子结构
     */
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
        System.out.println(hasSubTree(node1,a));
    }

    /**
     * 首先查看一当前节点为根节点是否正确
     * 然后查看左右节点
     * 如果其中有一个正确 就表明正确
     * @param root
     * @param a
     * @return
     */
    private static boolean hasSubTree(BinaryTreeNode root, BinaryTreeNode a) {
        if (root != null) {
            boolean rootBoolean = isSameTree(root, a);
            boolean left = hasSubTree(root.getLchild(), a);
            boolean right = hasSubTree(root.getRchild(), a);
            return rootBoolean || left || right;
        }

        return false;
    }

    /**
     *root1     8
     *      9       2
     *           4     7
     *
     * 与
     *root2     8
     *      9       2
     * 是相同的树
     * 所以如果root2 为null 另外一个不为null 叶子节点也正确
     * @param root1
     * @param root2
     * @return
     */
    private static boolean isSameTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        boolean left = isSameTree(root1.getLchild(), root2.getLchild());
        boolean right = isSameTree(root1.getRchild(), root2.getRchild());
        return left && right;
    }


}
