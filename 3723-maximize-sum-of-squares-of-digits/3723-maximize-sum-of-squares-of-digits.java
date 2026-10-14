class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num) return "";
        StringBuilder sb = new StringBuilder();
        while(sb.length() < num){
            if(sum>=9){
                sb.append(9);
                sum -= 9;
            }
            else if(sum != 0){
                sb.append(sum);
                sum = 0;
            }
            else{
                sb.append(0);
            }
        }
        return sb.toString();

    }
}