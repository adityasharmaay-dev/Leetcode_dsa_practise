class Solution {
    public int maxProfit(int[] arr, int fee) {
        int n = arr.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];
        for(int i=0; i<2; i++){
            ahead[i] = 0;
        }
        int profit = 0;
        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<2; buy++){
                if(buy == 0){
                    profit = Math.max((-arr[i] + ahead[1]), 
                                                        (ahead[0]));
                }
                else{
                    profit = Math.max((arr[i] - fee + ahead[0]), 
                                                        (ahead[1]));
                }
                curr[buy] = profit;
            }
            int[] temp = ahead;
            ahead = curr;
            curr = temp;
        }
        return ahead[0];
    }
}