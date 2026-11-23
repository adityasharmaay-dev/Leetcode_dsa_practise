class Solution {
    public boolean checkString(String s) {
        // if(s.contains("ba")) return false;
        // return true;
        boolean flag = true;
        int countA = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a' && flag == false){
                return false;
            }
            else if(s.charAt(i)=='a'){
                countA++;
            }
            else{
                flag = false;
            }
        }
        return true;
    }
}