class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;
        for (int x=0; x<n; x++) {
            if (arr[x] == 0) zeros++;
        }
        int i = n - 1;
        int j = n + zeros - 1;
        while (i < j) {
            if (j < n) arr[j] = arr[i];
            if (arr[i] == 0) {
                j--;
                if (j < n) arr[j] = 0;
            }
            i--;
            j--;
        }
    }
}