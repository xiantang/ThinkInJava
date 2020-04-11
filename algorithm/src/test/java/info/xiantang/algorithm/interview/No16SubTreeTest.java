package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class No16SubTreeTest {

    @Test
    public void testIsSubTree() {
        TreeNode a1 = new TreeNode(8);
        TreeNode a2 = new TreeNode(8);
        TreeNode a3 = new TreeNode(7);
        TreeNode a4 = new TreeNode(9);
        TreeNode a5 = new TreeNode(2);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a5.left = a6;
        a5.right = a7;
        TreeNode b1 = new TreeNode(8);
        TreeNode b2 = new TreeNode(9);
        TreeNode b3 = new TreeNode(2);
        b1.left = b2;
        b1.right = b3;
        boolean res = No16SubTree.valite(a1, b1);
        assertTrue(res);

    }

}
