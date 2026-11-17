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
    boolean isBal;
    public boolean isBalanced(TreeNode root) {
        isBal = true;
        helper(root);
        return isBal;
    }
    public int helper(TreeNode node){
        if(node == null) return 0;
        int l = helper(node.left);
        int r = helper(node.right);
        if(Math.abs(l-r)>1) isBal = false;
        return Math.max(l, r) + 1;
    }
}
