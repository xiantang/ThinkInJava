package info.xiantang.algorithm.offer.offer2;


public class BinaryTreeNode {
    int data;
    BinaryTreeNode Lchild;
    BinaryTreeNode Rchild;
    public BinaryTreeNode(int data) {
        super();
        this.data = data;
    }
    public BinaryTreeNode(int data, BinaryTreeNode lchild, BinaryTreeNode rchild) {
        super();
        this.data = data;
        Lchild = lchild;
        Rchild = rchild;
    }
    public int getData() {
        return data;
    }
    public void setData(char data) {
        this.data = data;
    }
    public BinaryTreeNode getLchild() {
        return Lchild;
    }
    public void setLchild(BinaryTreeNode lchild) {
        Lchild = lchild;
    }
    public BinaryTreeNode getRchild() {
        return Rchild;
    }
    public void setRchild(BinaryTreeNode rchild) {
        Rchild = rchild;
    }
}
