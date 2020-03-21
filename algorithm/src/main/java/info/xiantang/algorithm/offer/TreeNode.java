package info.xiantang.algorithm.offer;

/**
 * @Author: xiantang
 * @Date: 2019/7/14 12:16
 */
class LinkedNode {
    private int val;
    public LinkedNode pre;
    public LinkedNode next;

    public LinkedNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}

public class TreeNode {
    private int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    static TreeNode init() {
        TreeNode root = new TreeNode(6);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(7);
        root.left = left1;
        root.right = right1;
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(4);
        left1.left = left2;
        left1.right = right2;
        return root;
    }

    public LinkedNode dfs(TreeNode root,boolean isL) {
        if (root == null) {
            return null;
        }
        LinkedNode node = new LinkedNode(root.val);
        node.pre = dfs(root.left, true);
        node.next = dfs(root.right, false);
        if (node.pre ==null && node.next==null){
            return node;
        }
        LinkedNode cur = node;
        if (!isL) {
            while (cur.pre != null) {
                LinkedNode temp = cur;
                cur = cur.pre;
                cur.next = temp;
            }
            return cur;
        } else {
            while (cur.next != null) {
                LinkedNode temp = cur;
                cur = cur.next;
                cur.pre = temp;
            }

            return cur;
        }

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        LinkedNode linkedNode = root.dfs(root, false);
        while (linkedNode.pre != null) {
            linkedNode = linkedNode.pre;
        }
        System.out.println(linkedNode);

    }
}
