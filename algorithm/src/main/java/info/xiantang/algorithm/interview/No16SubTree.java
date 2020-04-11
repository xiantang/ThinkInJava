package info.xiantang.algorithm.interview;

public class No16SubTree {
    public static boolean valite(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        boolean rootB = false;
        if (root1.data == root2.data) {
            rootB = isEquals(root1, root2);
        }

        return rootB || valite(root1.left,root2) || valite(root1.right,root2);
    }

    private static boolean isEquals(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }



        return isEquals(root1.left, root2.left) && isEquals(root1.right, root2.right);
    }
}
