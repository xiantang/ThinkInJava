package info.xiantang.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

public class FindNextNodeByMidOrder {

    public static TreeNode find(TreeNode root, int i) {
        List<TreeNode> treeNodes = new ArrayList<>();
        find(root, treeNodes);
        boolean flag = false;
        for (TreeNode treeNode : treeNodes) {
            if (flag) {
                return treeNode;
            } else {
                if (treeNode.data == i) {
                    flag = true;
                }
            }

        }

        return null;
    }

    private static void find(TreeNode root, List<TreeNode> nodes) {

        if (root == null) {
            return;
        }
        find(root.left, nodes);
        nodes.add(root);
        find(root.right, nodes);

    }

}
