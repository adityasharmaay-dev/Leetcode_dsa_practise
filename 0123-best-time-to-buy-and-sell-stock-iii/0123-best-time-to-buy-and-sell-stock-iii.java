class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        // return helper(prices, n, 0, 0, 2, dp);
        for(int buy=0; buy<2; buy++){
            for(int cap=0; cap>3; cap++){
                dp[n][buy][cap] = 0;
            }
        }
        for(int i=0; i<n-1; i++){
            for(int buy=0; buy<2; buy++){
                dp[i][buy][0] = 0;
            }
        }
        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<2; buy++){
                for(int cap=1; cap<3; cap++){
                    if(buy == 0){
                        dp[i][buy][cap] = Math.max((-prices[i] + dp[i+1][1][cap]), 
                                                            dp[i+1][0][cap]);
                    }
                    else{
                        dp[i][buy][cap] = Math.max((prices[i] + dp[i+1][0][cap-1]),
                                                            dp[i+1][1][cap]);
                    }
                }
            }
        }
        return dp[0][0][2];
    }
    // public int helper(int[] arr, int n, int i, int buy, int cap, int[][][] dp){
    //     if(i==n || cap==0){
    //         return 0;
    //     }
    //     if(dp[i][buy][cap] != -1) return dp[i][buy][cap];
    //     int profit = 0;
        // if(buy == 0){
        //     profit = Math.max((-arr[i] + helper(arr, n, i+1, 1, cap, dp)), 
        //                                         (helper(arr, n, i+1, 0, cap, dp)));
        // }
        // else{
        //     profit = Math.max((arr[i] + helper(arr, n, i+1, 0, cap-1, dp)),
        //                                         (helper(arr, n, i+1, 1, cap, dp)));
        // }
    //     return dp[i][buy][cap] = profit;
    // }
}