class Solution {
    public int findPeakElement(int[] arr) {
        int lo = 0;
        int hi = arr.length-1;
        int n = arr.length;
        if(n==1) return 0;
        if(n==2){
            if(arr[0]>arr[1]){
                return 0;
            }
            else return 1;
        }
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(mid==0 && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(mid==n-1 && arr[mid] > arr[mid-1]){
                return mid;
            }
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(arr[mid] > arr[mid+1]){
                hi = mid;
            }
            else lo = mid + 1;
        }
        return lo;
    }
}