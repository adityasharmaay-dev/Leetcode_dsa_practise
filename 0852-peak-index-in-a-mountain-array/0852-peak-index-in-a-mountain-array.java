class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int ans = 0;
        while(hi >= lo){
            int mid = (hi + lo)/2;
            if(mid == 0 ){
                lo = mid + 1;
            }
            else if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(arr[mid] > arr[mid - 1]){
                ans = mid;
                lo = mid + 1;   
            }
            else hi = mid - 1;
        }
        return ans;
    }
}