class Solution {
    public String removeOuterParentheses(String s) {
        String ans = "";
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(count==0 && s.charAt(i)=='('){
                count++;
                continue;
            }
            if(count==1 && s.charAt(i)==')'){
                count--;
                continue;
            }
            if(s.charAt(i)=='('){
                ans += '(';
                count++;
            }
            else{
                ans += ')';
                count--;
            }
        }
        return ans;
    }
}