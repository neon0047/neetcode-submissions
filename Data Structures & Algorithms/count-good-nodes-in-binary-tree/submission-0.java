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
    int count;
    public int goodNodes(TreeNode root) {
        count = 0;
        if(root == null) return count;
        helper(root, root.val);
        return count;
    }
    public void helper(TreeNode root, int max){
        if(root == null) return ;
        if(root.val>=max) count++;
        helper(root.left, Math.max(max, root.val));
        helper(root.right, Math.max(max, root.val));
    }
}
