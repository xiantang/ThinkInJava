package offer.offer3;

import offer.offer2.BinaryTreeNode;

public class No27 {
    /**
     * .输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建人和新的结点，只能调整树中结点指针的指向。
     */
    public static void main(String[] args) {
        BinaryTreeNode root=new BinaryTreeNode(10);
        BinaryTreeNode node1=new BinaryTreeNode(6);
        BinaryTreeNode node2=new BinaryTreeNode(14);
        BinaryTreeNode node3=new BinaryTreeNode(4);
        BinaryTreeNode node4=new BinaryTreeNode(8);
        BinaryTreeNode node5=new BinaryTreeNode(12);
        BinaryTreeNode node6=new BinaryTreeNode(16);
        root.setLchild(node1);root.setRchild(node2);
        node1.setLchild(node3);node1.setRchild(node4);
        node2.setLchild(node5);node2.setRchild(node6);
        BinaryTreeNode head = covert(root, false);
        while(head!=null){
            System.out.println(head.getData());
            head = head.getRchild();
        }
    }

    private static BinaryTreeNode covert(BinaryTreeNode root,boolean isLeft) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode a =  covert(root.getLchild(),true);
        root.setLchild(a);
        if (a != null) {
            a.setRchild(root);
        }
        BinaryTreeNode b = covert(root.getRchild(), false);
        root.setRchild(b);
        if (b != null) {
            b.setLchild(root);
        }
        if (isLeft) {
            BinaryTreeNode node = root;
            while (node.getRchild() != null) {
                BinaryTreeNode tmp = node;
                node = node.getRchild();
                node.setLchild(tmp);
            }
            return node;
        } else {
            BinaryTreeNode node = root;
            while (node.getLchild() != null) {
                BinaryTreeNode tmp = node;
                node = node.getLchild();
                node.setRchild(tmp);
            }
            return node;
        }
    }

}
