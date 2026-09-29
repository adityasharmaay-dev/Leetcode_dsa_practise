class Solution {
    public int hIndex(int[] arr) {
        int n = arr.length;
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(n-mid == arr[mid]) return arr[mid];
            else if(n-mid > arr[mid]) lo = mid + 1;
            else hi = mid - 1;
        }
        return n - lo;
    }
}