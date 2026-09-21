class Solution {
    public int numDistinct(String s, String t) {
        int p = s.length();
        int q = t.length();
        int[][] dp = new int[p+1][q+1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        for(int i=0; i<p; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=p; i++){
            for(int j=1; j<=q; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[p][q];
    }
}