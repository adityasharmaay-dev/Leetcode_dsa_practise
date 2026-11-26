class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = helper(coins, amount, coins.length - 1, dp);
        if (ans == 1000000000) return -1;
        return ans;
    }

    public int helper(int[] arr, int rs, int i, int[][] dp) {
        if (i == 0) {
            if (rs % arr[0] == 0) return rs / arr[0];
            return 1000000000;
        }
        if(dp[i][rs] != -1) return dp[i][rs];
        int not = helper(arr, rs, i - 1, dp);
        int take = 1000000000;
        if (arr[i] <= rs) {
            int temp = helper(arr, rs - arr[i], i, dp);
            if (temp != 1000000000) {
                take = 1 + temp;
            }
        }
        return dp[i][rs] = Math.min(take, not);
    }
}