class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sum = 0;
        for(int i=0; i<n; i++){
            HashSet<Integer> s = new HashSet<>();
            for(int j=i; j<n; j++){
                s.add(nums.get(j));
                int d = s.size();
                sum += d*d;

            }
        }
        return sum;
    }
}