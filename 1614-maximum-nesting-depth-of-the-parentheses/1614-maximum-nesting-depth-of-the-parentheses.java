class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int Maxdepth = 0;   
        return helper(0, s, 0, 0);
    }
    public int helper(int i, String s, int depth, int Maxdepth){
        if(i == s.length()){
            return Maxdepth;
        }
        if(s.charAt(i) == '('){
            depth++;
            Maxdepth = Math.max(Maxdepth, depth);
        }
        if(s.charAt(i) == ')'){
            depth--;
        }
        return helper(i+1, s, depth, Maxdepth);
    }
}