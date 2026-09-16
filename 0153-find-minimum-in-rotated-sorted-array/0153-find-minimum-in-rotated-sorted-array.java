class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int lo, int hi) {
        int min = Integer.MAX_VALUE;
        while (lo <= hi) {
            if (nums[lo] <= nums[hi]) {
                min = Math.min(min, nums[lo]);
                break;
            }
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] <= nums[mid]) {
                min = Math.min(min, nums[lo]);
                lo = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                hi = mid - 1;
            }
        }
        return min;
    }
}