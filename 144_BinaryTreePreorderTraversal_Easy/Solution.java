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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrderRec(root, result);
        return result;
    }

    private void preOrderRec(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        preOrderRec(root.left, result);
        preOrderRec(root.right, result);
    }
}