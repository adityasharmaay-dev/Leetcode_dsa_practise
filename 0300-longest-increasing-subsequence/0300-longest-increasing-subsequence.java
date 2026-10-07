class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return helper(nums, n, 0, -1, dp);
    }
    public int helper(int[] nums, int n, int idx, int prev, int[][] dp){
        if(idx == n){
            return 0;
        }
        if(dp[idx][prev+1] != -1) return dp[idx][prev+1];
        int len = 0 + helper(nums, n, idx+1, prev, dp);  //not take
        if(prev == -1 || nums[idx] > nums[prev]){
            len = Math.max(len, 1 + helper(nums, n, idx+1, idx, dp));  //take
        }
        return dp[idx][prev+1] = len;
    }
}