class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] a = new int[n+2];
        a[0] = 1;
        a[n+1] = 1;

        for(int i=1; i<=n; i++){
            a[i] = nums[i-1];
        }

        int[][] dp = new int[n+2][n+2];

        for(int i=n; i>=1; i--){
            for(int j=i; j<=n; j++){
                int maxi = Integer.MIN_VALUE;

                for(int ind=i; ind<=j; ind++){
                    int cost = a[i-1] * a[ind] * a[j+1]
                            + dp[i][ind-1]
                            + dp[ind+1][j];

                    maxi = Math.max(maxi, cost);
                }

                dp[i][j] = maxi;
            }
        }

        return dp[1][n];
    }
}