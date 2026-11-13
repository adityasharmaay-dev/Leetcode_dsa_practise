class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long count = 0;
        int last = -1;
        for(int i=0; i<n; i++){
            if(nums[i]>= minK && nums[i]<=maxK){
                int p = i-last;
                count += p;
            }
            else last = i;
        }
        return count;
    }
}