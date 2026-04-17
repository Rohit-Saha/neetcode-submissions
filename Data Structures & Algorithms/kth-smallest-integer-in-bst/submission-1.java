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
    public int kthSmallest(TreeNode root, int k) {

        // List<Integer> list = new ArrayList<>();

        // inorder(root, list);

        // return list.get(k-1);

        int[] arr = new int[2];
        arr[0] = k;
        inorder(root, arr);
        return arr[1];
        
    }

    // private void inorder(TreeNode root, List<Integer> list) {
    //     if(root == null) {
    //         return;
    //     }

    //     inorder(root.left, list);
    //     list.add(root.val);
    //     inorder(root.right, list);
    // }

    private void inorder(TreeNode root, int[] arr) {
        if(root == null) {
            return;
        }

        inorder(root.left, arr);
        arr[0] = arr[0] - 1;
        if(arr[0] == 0) {
            arr[1] = root.val;
            return;
        }
        inorder(root.right, arr);
    }

}
