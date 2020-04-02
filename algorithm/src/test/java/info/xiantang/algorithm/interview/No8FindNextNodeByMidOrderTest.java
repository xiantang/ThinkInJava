package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No8FindNextNodeByMidOrderTest {

    @Test
    public void findNextNodeMidOrder() {
//        int[] midOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = new TreeNode(1);
        TreeNode c2 = new TreeNode(2);
        TreeNode c3 = new TreeNode(3);
        root.left = c2;
        root.right = c3;
        TreeNode c4 = new TreeNode(4);
        TreeNode c7 = new TreeNode(7);
        c2.left = c4;
        c4.right = c7;
        TreeNode c5 = new TreeNode(5);
        TreeNode c6 = new TreeNode(6);
        c3.left = c5;
        c3.right = c6;
        TreeNode c8 = new TreeNode(8);
        c6.left = c8;
        TreeNode node = FindNextNodeByMidOrder.find(root,3);
        assertEquals(c8, node);
    }

}
