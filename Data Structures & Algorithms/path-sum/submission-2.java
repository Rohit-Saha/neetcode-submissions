/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        } 

        sum += root.val;
        if (root.left == null && root.right == null && targetSum == sum) {
            return true;
        }

        if (dfs(root.left, targetSum, sum)) {
            return true;
        } else if (dfs(root.right, targetSum, sum)) {
            return true;
        }

        sum -= root.val;

        return false;
    }
}