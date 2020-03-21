package info.xiantang.algorithm.offer.offer1;

import java.util.Arrays;

/**
 * @Author: xiantang
 * @Date: 2019/9/5 18:58
 */
public class Solution {

    class TreeNode {
   int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0){
            return null;
        }

        int first = pre[0];
        TreeNode root = new TreeNode(first);
        int index = 0;
        for(int i = 0;i<in.length;i++){
            if(in[i] == first){
                index = i;
                break;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,index+1),Arrays.copyOfRange(in,0,index));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,index+1,pre.length),Arrays.copyOfRange(in,index+1,pre.length));
        return root;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        s.reConstructBinaryTree(pre, in);
    }
}
