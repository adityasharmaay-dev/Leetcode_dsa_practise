class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0; 
        int j = 0;
        int total = 0;
        int ans = Integer.MAX_VALUE;
        while(i<n && j<n){
            total += nums[j];
            j++;
            while(total >= target){
                ans = Math.min(ans, j-i);
                total -= nums[i];
                i++;
            }
            
        }
        if(ans == Integer.MAX_VALUE) return 0;
        return ans;
    }
}