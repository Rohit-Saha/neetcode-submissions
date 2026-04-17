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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        return String.join(",", res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] elements = data.split(",");
        int[] i = {0};
        return dfsDeserialize(elements, i);
    }

    private TreeNode dfsDeserialize(String[] elements, int[] i) {
        if(elements[i[0]].equals("N")) {
            i[0] += 1;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(elements[i[0]]));
        i[0] += 1;
        node.left = dfsDeserialize(elements, i);
        node.right = dfsDeserialize(elements, i);
        return node;
    }

    private void dfsSerialize(TreeNode root, List<String> res) {
        if(root == null) {
            res.add("N");
            return;
        }

        res.add(String.valueOf(root.val));
        dfsSerialize(root.left, res);
        dfsSerialize(root.right, res);
    }
}
