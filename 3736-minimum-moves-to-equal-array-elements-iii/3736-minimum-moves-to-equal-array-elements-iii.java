class Solution {
    public int minMoves(int[] nums) {
        int mm = Max(nums);
        int moves = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<mm){
                moves += mm-nums[i];
            }
        }
        return moves;
    }
    public int Max(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}