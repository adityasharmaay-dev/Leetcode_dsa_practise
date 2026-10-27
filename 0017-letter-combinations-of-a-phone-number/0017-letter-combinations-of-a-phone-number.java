class Solution {
    static String[] code = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        helper(digits, "", result);
        return result;
    }

    private void helper(String ques, String ans, List<String> result) {
        if (ques.length() == 0) {
            result.add(ans);
            return;
        }

        char ch = ques.charAt(0);
        String press = code[ch - '0'];

        for (int i = 0; i < press.length(); i++) {
            helper(ques.substring(1), ans + press.charAt(i), result);
        }
    }
}