class Solution {

    public static int minimumMountainRemovals(int[] arr) {

        int n = arr.length;

        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);

        int max = helper(arr, n, dp1, dp2);

        return n - max;
    }

    public static int helper(int[] arr, int n, int[] dp1, int[] dp2) {

        // LIS ending at i
        for(int i = 0; i < n; i++) {

            for(int prev = 0; prev < i; prev++) {

                if(arr[prev] < arr[i]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[prev]);
                }
            }
        }

        // LDS starting at i
        for(int i = n - 1; i >= 0; i--) {

            for(int next = i + 1; next < n; next++) {

                if(arr[next] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], 1 + dp2[next]);
                }
            }
        }

        int max = 0;

        for(int i = 0; i < n; i++) {

            if(dp1[i] > 1 && dp2[i] > 1) {

                int bitonic = dp1[i] + dp2[i] - 1;

                max = Math.max(max, bitonic);
            }
        }

        return max;
    }
}