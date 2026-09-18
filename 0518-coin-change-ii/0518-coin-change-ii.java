class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(coins, amount, coins.length-1, dp);
    }
    public int helper(int[] arr, int rs, int n, int[][] dp){
        if(n==0){
            if(rs % arr[0] == 0){
                return 1;
            }
            return 0;
        }
        if(dp[n][rs] != -1) return dp[n][rs];
        int not = helper(arr, rs, n-1, dp);
        int take = 0;
        if(rs >= arr[n]){
            take = helper(arr, rs-arr[n], n, dp);
        }
        return dp[n][rs] = take + not;
    }
}