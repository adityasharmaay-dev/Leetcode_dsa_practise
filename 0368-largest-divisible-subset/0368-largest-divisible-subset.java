class Solution {
    public static List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int[] ans = helper(arr, n, dp);
        List<Integer> ll = new ArrayList<Integer>();
        for(int i=0; i<ans.length; i++){
            ll.add(ans[i]);
        }
        return ll;
    }
    public static int[] helper(int[] arr, int n,int[] dp) {
		
		int max = 1;
		int[] hash = new int[n];
		int lastidx = 0;
		for(int i=0; i<n; i++) {
			hash[i] = i;
			for(int prev=0; prev<i; prev++) {
				if(arr[i]%arr[prev]==0 && 1+dp[prev] > dp[i]) {
					dp[i] = 1+dp[prev];
					hash[i] = prev;
				}
			}
			if(dp[i] > max) {
				max = dp[i];
				lastidx = i;
			}
		}
		int[] lis = new int[max];
		lis[0] = arr[lastidx];
		int i = 1;
		while(hash[lastidx] != lastidx) {
			lastidx = hash[lastidx];
			lis[i++] = arr[lastidx];
		}
		int[] ans = new int[max];
		int k=0;
		for(int j=max-1; j>=0; j--) {
			
			ans[k++] = lis[j];
		}
		return ans;
	}
}