class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int idx=n-1; idx>=0; idx--){
            for(int prev=idx-1; prev>=-1; prev--){
                int len = 0 + dp[idx+1][prev+1];  //not take
                if(prev == -1 || nums[idx] > nums[prev]){
                    len = Math.max(len, 1 + dp[idx+1][idx+1]);  //take
                }
                dp[idx][prev + 1] = len;
            }
        }
        return dp[0][0];
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