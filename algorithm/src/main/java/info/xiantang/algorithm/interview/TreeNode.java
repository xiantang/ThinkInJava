package info.xiantang.algorithm.interview;

import java.util.Objects;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int data;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return data == treeNode.data &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, data);
    }


}
