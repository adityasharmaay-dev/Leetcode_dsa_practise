class Solution {
    public int minOperations(int[] nums, int x) {
        //longest subarray whose sum is total - x;
        int total = Sum(nums);
        if(total<x) return -1;
        int target = total-x;
        int i = 0;
        int s = 0;
        int size = -1;
        for(int j = 0 ; j < nums.length ; ++j){
            s += nums[j];
            while(i <= j && s > target){
                s -= nums[i++]; 
            }
            if(s == target){
                size = Math.max(size,j - i +1);
            }
        }
        if(size == -1){
            return -1;
        }
        return nums.length - size;
    }
    public int Sum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
}