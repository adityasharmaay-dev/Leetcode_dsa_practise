class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+2][2];
        // for(int i=0; i<2; i++){
        //     dp[n][i] = 0;
        // }
        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<2; buy++){
                if(buy == 0){
                    dp[i][buy] = Math.max((-arr[i] + dp[i+1][1]), 
                                                        (dp[i+1][0]));
                }
                else{
                    dp[i][buy] = Math.max((arr[i] + dp[i+2][0]), 
                                                        (dp[i+1][1]));
                }
            }
        }
        return dp[0][0];
    }
    // public int helper(int[] arr, int i, int buy, int n, int[][] dp){
    //     if(i >= n) return 0;
    //     if(dp[i][buy] != -1) return dp[i][buy];
    //     int profit = 0;
    //     if(buy == 0){
    //         profit = Math.max((-arr[i] + helper(arr, i+1, 1, n, dp)), 
    //                                             (helper(arr, i+1, 0, n, dp)));
    //     }
    //     else{
    //         profit = Math.max((arr[i] + helper(arr, i+2, 0, n, dp)),
    //                                             (helper(arr, i+1, 1, n, dp)));
    //     }
    //     return dp[i][buy] = profit;
    // }
}