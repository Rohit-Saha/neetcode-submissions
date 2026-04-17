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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int leftBoundary, int rightBoundary) {
        if(root == null) {
            return true;
        }

        if(root.val > leftBoundary && root.val < rightBoundary) {
            boolean isValidLeftTree = isValidBST(root.left, leftBoundary, root.val);
            if(!isValidLeftTree) {
                return false;
            }
            boolean isValidRightTree = isValidBST(root.right, root.val, rightBoundary);
            return isValidRightTree;
        } else {
            return false;
        }
    }
}
