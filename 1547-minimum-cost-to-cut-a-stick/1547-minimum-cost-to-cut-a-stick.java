class Solution {
    public int minCost(int n, int[] cuts) {
        int a = cuts.length;
        int[] arr = new int[a+2];
        arr[0] = 0;
        arr[a+1] = n;

        for(int i=1; i<=a; i++){
            arr[i] = cuts[i-1];
        }

        Arrays.sort(arr);

        int[][] dp = new int[a+2][a+2];

        for(int i=a; i>=1; i--){
            for(int j=i; j<=a; j++){
                int min = 100000000;

                for(int ind=i; ind<=j; ind++){
                    int cost = arr[j+1]-arr[i-1] + dp[i][ind-1] + dp[ind+1][j];
                    min = Math.min(min, cost);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][a];
    }
}