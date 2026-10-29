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
    int dia;
    public int diameterOfBinaryTree(TreeNode root) {
        dia = 0;
        helper(root);
        return dia;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int lh = helper(root.left);
        int rh = helper(root.right);
        dia = Math.max(dia, lh+rh);

        return Math.max(lh, rh) + 1;

    }
}
