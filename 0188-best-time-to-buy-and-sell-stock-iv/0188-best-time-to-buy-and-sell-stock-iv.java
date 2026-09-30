class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][k+1];
        int[][] curr = new int[2][k+1];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 0) {
                        curr[buy][cap] = Math.max(
                            -prices[i] + after[1][cap],
                            after[0][cap]
                        );
                    } else {
                        curr[buy][cap] = Math.max(
                            prices[i] + after[0][cap - 1],
                            after[1][cap]
                        );
                    }
                }
            }
            after = curr;
            curr = new int[2][k+1];
        }

        return after[0][k];
    }
}