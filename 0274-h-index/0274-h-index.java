class Solution {
    public int hIndex(int[] citations) {
        int lo = 0;
        int hi = citations.length;
        int ans = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(isitpossible(citations, mid)==true){
                ans = mid;
                lo = mid + 1;
            }
            else hi = mid - 1;
        }
        return ans;
    }
    public static boolean isitpossible(int[] arr, int mid){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(mid <= arr[i]){
                count++;
            }
        }
        if(count >= mid) return true;
        return false;
    }
}