/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        int[] res = dfs(root);

        return res[0] == 1 ? true : false; 
    }

    private int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[] {1, 0};
        }

        int[] l = dfs(root.left);
        int[] r = dfs(root.right);

        int balanced = ((Math.abs(l[1] - r[1]) <= 1) && (l[0] ==1) && (r[0] == 1)) ? 1 : 0;



        int h = Math.max(l[1], r[1]) + 1;

        return new int[] {balanced, h};
    } 
}
