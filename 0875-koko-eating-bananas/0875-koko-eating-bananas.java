class Solution {
    public int minEatingSpeed(int[] arr, int h) {
		int lo = 1;
		int hi = MaxA(arr);
		while(hi>lo) {
			int mid = (hi + lo)/2;
			if(isitpossible(arr, h, mid) == true) {
				hi = mid ;
			}
			else lo = mid + 1;
		}
		return lo;
	}
	public static boolean isitpossible(int[] arr, int h, int mid) {
		long hours = 0;
		for(int i=0; i<arr.length; i++) {
			hours += (arr[i] + mid - 1)/mid;
		}
		if(hours <= h) return true;
		return false;
	}
	public static int MaxA(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			max = Math.max(arr[i],  max);
		}
		return max;
    }
}