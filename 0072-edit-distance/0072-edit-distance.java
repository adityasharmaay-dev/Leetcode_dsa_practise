class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        for(int i=0; i<=m; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=n; j++){
            dp[0][j] = j;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = 1 + dp[i][j-1];
                    int del = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(Math.min(insert,del), replace);
                }
            }
        }
        return dp[m][n];
    }
    // public int helper(String s1, String s2, int i, int j, int[][] dp){
    //     if(i<0){
    //         return j+1;
    //     }
    //     if(j<0){
    //         return i+1;
    //     }
    //     if(dp[i][j] != -1) return dp[i][j];

    //     if(s1.charAt(i) == s2.charAt(j)){
    //         return dp[i][j] = helper(s1, s2, i-1, j-1, dp);
    //     }
    //     int insert = 1 + helper(s1,s2,i,j-1, dp);
    //     int del = 1 + helper(s1,s2,i-1,j, dp);
    //     int replace = 1 + helper(s1,s2,i-1,j-1, dp);

    //     return dp[i][j] = Math.min(Math.min(insert,del), replace);
    // }
}
