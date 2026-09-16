class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = maxA(weights);
        int hi = sumA(weights);
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(isitpossible(weights, days, mid)){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    public boolean isitpossible(int[] arr, int days, int mid){
        int count = 1;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] + sum <= mid){
                sum += arr[i];
            }
            else{
                count++;
                sum = arr[i];
            }
        }
        if(count <= days) return true;
        return false;
    }
    public int maxA(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    public int sumA(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
}