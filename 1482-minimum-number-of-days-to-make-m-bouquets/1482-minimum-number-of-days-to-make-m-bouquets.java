class Solution {
    public int minDays(int[] arr, int m, int k) {
        if((long)m*k > arr.length){
            return -1;
        }
        int lo = 1;
        int hi = maxA(arr);
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(isitpossible(arr, m, k, mid)){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }
        return lo;
	}
    public boolean isitpossible(int[] arr, int m, int k, int mid){
        int count = 0;
        int num = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>mid){
                count = 0;
                continue;
            }
            count++;
            if(count==k){
                num++;
                count = 0;
            }
        }
        if(num >= m) return true;
        return false;
    }
    public int maxA(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
    
}