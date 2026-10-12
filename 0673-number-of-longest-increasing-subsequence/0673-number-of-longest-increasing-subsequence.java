class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int[] cnt = new int[n];
		Arrays.fill(cnt, 1);
		int ans = helper(nums, n, dp, cnt);
        return ans;
    }
    public static int helper(int[] arr, int n,int[] dp, int[] cnt) {
		int max = 1;
		for(int i=0; i<n; i++) {
			for(int prev=0; prev<i; prev++) {
				if(arr[prev]<arr[i] && 1+dp[prev] > dp[i]) {
					dp[i] = 1+dp[prev];
					cnt[i] = cnt[prev];
				}
				else if(arr[prev]<arr[i] && 1+dp[prev] == dp[i]) {
					cnt[i] += cnt[prev];
				}
			}
			max = Math.max(max, dp[i]);
		}
		int num = 0;
		for(int i=0; i<n; i++) {
			if(dp[i] == max) {
				num += cnt[i];
			}
		}
		return num;
	}
}