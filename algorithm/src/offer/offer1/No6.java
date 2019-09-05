package offer.offer1;

import java.util.Arrays;

public class No6 {
    public static TreeNode build(String preOrder, String midOrder) {
//        String preOrder = "12473568";
//        String midOrder = "47215386";

        if (preOrder.length() == 0) {
            return null;
        }
        char first = preOrder.charAt(0);
        TreeNode root = new TreeNode(first);
        int index = 0;
        for (int i = 0; i < midOrder.length(); i++) {
            if (first == midOrder.charAt(i)) {
                index = i;
                break;
            }
        }

        root.setLchild(build(preOrder.substring(1, index + 1), midOrder.substring(0,index)));
        root.setRchild(build(preOrder.substring(index + 1), midOrder.substring(index + 1)));
        return root;
    }

    public static void postRootTraverse(TreeNode root) {
        if (root != null) {
            postRootTraverse(root.getLchild());
            System.out.print(root.getData());
            postRootTraverse(root.getRchild());

        }
    }

    public static void main(String[] args) {
        String preOrder = "12473568";
        String midOrder = "47215386";
        TreeNode treeNode = build(preOrder, midOrder);
        postRootTraverse(treeNode);

    }
}
