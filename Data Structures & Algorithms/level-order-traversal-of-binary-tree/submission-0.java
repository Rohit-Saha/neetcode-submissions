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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        if(root != null) {
            deque.offer(root);
        }
        

        while(deque.size() > 0) {
            List<Integer> level = new ArrayList<>();
            int len = deque.size();
            for(int i=0; i<len; i++) {
                TreeNode curr = deque.poll();

                if(curr.left != null) {
                    deque.offer(curr.left);
                }
                if(curr.right != null) {
                    deque.offer(curr.right);
                }
                level.add(curr.val);
            }

            output.add(level);

            
        }
        return output;
    }
}
