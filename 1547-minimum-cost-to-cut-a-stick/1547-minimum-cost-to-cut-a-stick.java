class Solution {
    public int minCost(int n, int[] cuts) {
        int a = cuts.length;
        int[] arr = new int[a+2];
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if(i==0){
                arr[0] = 0;
            }
            else if(i==arr.length-1){
                arr[i] = n;
            }
            else{
                arr[i] = cuts[idx++];
            }
        }
        int[][] dp = new int[a+1][a+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        Arrays.sort(arr);
        return f(arr, 1, a, dp);
    }
    public int f(int[] cuts, int i, int j, int[][] dp){
        if(i>j) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int min = 100000000;
        for(int ind = i; ind<=j; ind++){
            int cost = cuts[j+1]-cuts[i-1] + f(cuts, i, ind-1, dp) + f(cuts, ind+1, j, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}