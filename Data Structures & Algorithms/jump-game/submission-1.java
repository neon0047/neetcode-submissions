class Solution {
    Integer[] dp;
    public boolean canJump(int[] nums) {
        dp = new Integer[nums.length+1];
        return helper(nums, 0)==1?true:false;
    }
    public Integer helper(int[] nums, int idx){
        if(idx>=nums.length-1) {
            return dp[nums.length - 1] = 1;
        }
        if(dp[idx] != null) return dp[idx];
        for(int i = 1; i<=nums[idx]; i++){
            if(helper(nums, idx + i)==1) return dp[idx] = 1;
        }
        return dp[idx] = 0;
    }
}
