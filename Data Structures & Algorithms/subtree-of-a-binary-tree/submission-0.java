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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }

        if(isSameTree(root, subRoot)) {
            return true;
        } else {
            boolean isLeftSubroot = isSubtree(root.left, subRoot);

            if(isLeftSubroot) {
                return true;
            }

            boolean isRightSubroot = isSubtree(root.right, subRoot);

            if(isRightSubroot) {
                return true;
            }
        }

        return false;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        } else if(p != null && q != null && p.val == q.val) {
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            return left && right;
        } else {
            return false;
        }
    }
}
