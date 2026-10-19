class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        int n = pos.length;
        int ans = 0;

        double[][] cars = new double[n][2];
        for(int i=0; i<n; i++){
            cars[i][0] = pos[i];
            cars[i][1] = (double)(target - pos[i]) / speed[i];
        }
        Arrays.sort(cars, (a,b) -> Double.compare(a[0], b[0]));
        double slow = 0;
        for(int i=n-1; i>=0; i--){
            if(cars[i][1] > slow){
                slow = cars[i][1];
                ans++;
            }
        }

        return ans;
    }
}