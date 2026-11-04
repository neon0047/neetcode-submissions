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

    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return helper(root, root.val);

    }
    public int helper(TreeNode root, int max){
        if(root == null) return 0;
        
        int l = helper(root.left, Math.max(max, root.val));
        int r = helper(root.right, Math.max(max, root.val));

        if(root.val>=max) return l+r+1;
        else return l+r;
    }
}
