class Solution {
    public boolean search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length-1);
    }
    public boolean helper(int[] nums, int k, int lo, int hi){
        boolean ans = false;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == k){
                ans = true;
               break;
            }
            if (nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
                lo++;
                hi--;
                continue;
            }
            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= k && k < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }

            } else {
                if (nums[mid] < k && k <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return ans;
    }
}