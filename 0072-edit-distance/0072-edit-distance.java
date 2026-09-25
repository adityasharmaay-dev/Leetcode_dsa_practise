class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(word1, word2, word1.length()-1, word2.length()-1, dp);
    }
    public int helper(String s1, String s2, int i, int j, int[][] dp){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = helper(s1, s2, i-1, j-1, dp);
        }
        int insert = 1 + helper(s1,s2,i,j-1, dp);
        int del = 1 + helper(s1,s2,i-1,j, dp);
        int replace = 1 + helper(s1,s2,i-1,j-1, dp);

        return dp[i][j] = Math.min(Math.min(insert,del), replace);
    }
}
