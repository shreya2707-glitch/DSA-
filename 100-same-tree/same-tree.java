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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both are null -> identical
        if (p == null && q == null) {
            return true;
        }

        // One is null while the other is not -> not identical
        if (p == null || q == null) {
            return false;
        }

        // Values do not match -> not identical
        if (p.val != q.val) {
            return false;
        }

        // Check left and right subtrees recursively
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}