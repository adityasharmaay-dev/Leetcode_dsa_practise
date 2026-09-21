class Solution {
    public int numDistinct(String s, String t) {
        int p = s.length();
        int q = t.length();
        int[][] dp = new int[p][q];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(s,t,dp,p-1,q-1);
    }
    public int helper(String s, String t, int[][] dp, int i, int j){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = helper(s,t,dp,i-1,j-1) + helper(s,t,dp,i-1,j);
        }
        return dp[i][j] = helper(s,t,dp,i-1,j);
    }
}