class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];
        for(int i=0; i<2; i++){
            ahead[i] = 0;
        }
        int profit = 0;
        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<2; buy++){
                if(buy == 0){
                    profit = Math.max((-arr[i] + ahead[1]), 
                                                        (ahead[0]));
                }
                else{
                    profit = Math.max((arr[i] + ahead[0]), 
                                                        (ahead[1]));
                }
                curr[buy] = profit;
            }
            int[] temp = ahead;
            ahead = curr;
            curr = temp;
        }
        return ahead[0];
    }
    // public int helper(int[] arr, int i, int buy, int n, int[][] dp){
    //     if(i == n) return 0;
    //     if(dp[i][buy] != -1) return dp[i][buy];
    //     int profit = 0;
    //     if(buy == 0){
    //         profit = Math.max((-arr[i] + helper(arr, i+1, 1, n, dp)), 
    //                                             (helper(arr, i+1, 0, n, dp)));
    //     }
    //     else{
    //         profit = Math.max((arr[i] + helper(arr, i+1, 0, n, dp)),
    //                                             (helper(arr, i+1, 1, n, dp)));
    //     }
    //     return dp[i][buy] = profit;
    // }
}