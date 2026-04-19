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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        Deque<TreeNode> q = new LinkedList<>();

        if(root != null) {
            q.offer(root);
        }

        while(!q.isEmpty()) {
            int len = q.size();
            TreeNode rightNode = null;
            for(int i=0; i<len; i++) {
                rightNode = q.poll();
                if(rightNode.left != null) {
                    q.offer(rightNode.left);
                }

                if(rightNode.right != null) {
                    q.offer(rightNode.right);
                }
                
            }
            res.add(rightNode.val);
        }

        return res;
    }

    

}
