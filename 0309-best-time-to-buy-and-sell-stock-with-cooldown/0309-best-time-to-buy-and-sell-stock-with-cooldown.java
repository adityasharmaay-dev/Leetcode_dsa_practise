class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int[] front2 = new int[2];
        int[] front1 = new int[2];
        int[] curr = new int[2];
        // for(int i=0; i<2; i++){
        //     dp[n][i] = 0;
        // }
        for(int i=n-1; i>=0; i--){
            curr[0] = Math.max((-arr[i] + front1[1]), (front1[0]));

            curr[1] = Math.max((arr[i] + front2[0]), (front1[1]));

            front2 = front1;
            front1 = curr;
            curr = new int[2];
        }
        return front1[0];
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