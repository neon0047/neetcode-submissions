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
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        count = 1;
        ans = -1;
        dfs(root, k);
        return ans;
    }
    public void dfs(TreeNode root, int k){
        if(root == null) return ;
        dfs(root.left, k);
        if(k == count) {
            ans = root.val;
        }
        count++;
        dfs(root.right, k);
    }
}
