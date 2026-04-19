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
        Deque<TreeNode> queue = new LinkedList<>();

        if(root != null) {
            queue.offer(root);
        }
        

        while(!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<len; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
                
            }
            output.add(list);
        }
        return output;
    }
}
