class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return helper(prices, 0, 0, n, dp);
    }
    public int helper(int[] arr, int i, int buy, int n, int[][] dp){
        if(i >= n) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        int profit = 0;
        if(buy == 0){
            profit = Math.max((-arr[i] + helper(arr, i+1, 1, n, dp)), 
                                                (helper(arr, i+1, 0, n, dp)));
        }
        else{
            profit = Math.max((arr[i] + helper(arr, i+2, 0, n, dp)),
                                                (helper(arr, i+1, 1, n, dp)));
        }
        return dp[i][buy] = profit;
    }
}