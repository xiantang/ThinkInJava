package info.xiantang.algorithm.offer.offer1;

import java.util.Objects;

public class TreeNode {
    public char data;
    public TreeNode lChild;
    public TreeNode rChild;
    public TreeNode(char data) {
        super();
        this.data = data;
    }
    public TreeNode(char data, TreeNode lChild, TreeNode rChild) {
        super();
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }
    public char getData() {
        return data;
    }
    public void setData(char data) {
        this.data = data;
    }
    public TreeNode getlChild() {
        return lChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return data == treeNode.data &&
                Objects.equals(lChild, treeNode.lChild) &&
                Objects.equals(rChild, treeNode.rChild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, lChild, rChild);
    }

    public void setlChild(TreeNode lChild) {
        this.lChild = lChild;
    }
    public TreeNode getrChild() {
        return rChild;
    }
    public void setrChild(TreeNode rChild) {
        this.rChild = rChild;
    }
}
