class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left<right){
            while(left<right && !isvowel(arr[left])){
                left++;
            }
            while(left<right && !isvowel(arr[right])){
                right--;
            }
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String (arr);
    }
    public boolean isvowel(char i){
        if(i=='a'||i=='A'||i=='e'||i=='E'||i=='i'||i=='I'||i=='o'||i=='O'||i=='u'||i=='U'){
            return true;
        }
        return false;
    }
}