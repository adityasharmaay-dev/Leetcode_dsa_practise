class Solution {
    public static int longestStrChain(String[] words) {

        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int ans = helper(words, n, dp);
        return ans;
    }
    public static int helper(String[] arr, int n, int[] dp) {

        int max = 1;

        for(int i = 1; i < n; i++) {

            for(int prev = 0; prev < i; prev++) {

                if(check(arr[i], arr[prev]) &&
                   1 + dp[prev] > dp[i]) {

                    dp[i] = 1 + dp[prev];
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static boolean check(String s1, String s2) {
        if(s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int sec = 0;

        while(first < s1.length() && sec < s2.length()) {

            if(s1.charAt(first) == s2.charAt(sec)) {
                first++;
                sec++;
            }
            else {
                first++;
            }
        }

        return sec == s2.length();
    }
}