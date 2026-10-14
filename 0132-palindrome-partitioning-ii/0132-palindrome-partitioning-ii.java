class Solution {
    public int minCut(String s) {
        int n = s.length();
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		int ans = f(s,0,n,dp) - 1;
        return ans;
    }
    public static int f(String s, int i, int n, int[] dp) {
		if(i==n) return 0;
		if(dp[i] != -1) return dp[i];
		int min = Integer.MAX_VALUE;
		for(int j=i; j<n; j++) {
			if(isPalindrome(i,j,s)) {
				int cost = 1 + f(s,j+1, n, dp);
				min = Math.min(min, cost);
			}
		}
		return dp[i] = min;
	}
	public static boolean isPalindrome(int i, int j, String s) {
		
		while(i<j) {
			if(s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
}