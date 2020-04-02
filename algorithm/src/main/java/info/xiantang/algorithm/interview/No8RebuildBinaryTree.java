package info.xiantang.algorithm.interview;

import java.util.Arrays;

class No8RebuildBinaryTree {
    static TreeNode rebuild(int[] preOrder, int[] midOrder) {
        if (preOrder.length == 0 || midOrder.length == 0) {
            return null;
        }
        int rootVal = preOrder[0];
        TreeNode root = new TreeNode(rootVal);
        int cutIndex = 0;
        for (int i = 0; i < midOrder.length; i++) {
            int value = midOrder[i];
            if (value == rootVal) {
                cutIndex = i;
            }
        }
        int[] midOrderLeft = Arrays.copyOfRange(midOrder, 0, cutIndex);
        int[] midOrderRight = Arrays.copyOfRange(midOrder, cutIndex + 1, midOrder.length);
        int[] preOrderLeft =  Arrays.copyOfRange(preOrder, 1, 1 + cutIndex);
        int[] preOrderRight = Arrays.copyOfRange(preOrder, preOrder.length -1 - cutIndex, preOrder.length);
        root.left = rebuild(preOrderLeft, midOrderLeft);
        root.right = rebuild(preOrderRight, midOrderRight);
        return root;
    }
}
