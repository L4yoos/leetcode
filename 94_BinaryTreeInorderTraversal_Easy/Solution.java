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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inOrderDFS(root, result);

        return result;
    }

    private void inOrderDFS(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inOrderDFS(node.left, result);

        result.add(node.val);

        inOrderDFS(node.right, result);
    }
}