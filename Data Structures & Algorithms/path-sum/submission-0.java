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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int pathSum) {
        if(root == null) {
            return false;
        }

        pathSum += root.val;

        if(root.left == null && root.right == null && pathSum == targetSum) {
            return true;
        } else if(hasPathSum(root.left, targetSum, pathSum)) {
            return true;
        } else if(hasPathSum(root.right, targetSum, pathSum)) {
            return true;
        }

        return false;
    }
}