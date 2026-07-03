class Solution {
    String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    
    void backtrack(String dig, int i, StringBuilder sb, List<String> result) {
        if(i == dig.length()){
            result.add(sb.toString());
            return;
        }
        String str = keypad[dig.charAt(i) - '0'];
        for(int j = 0; j <str.length(); j++) {
            sb.append(str.charAt(j));
            backtrack(dig, i+1, sb, result);
            sb.deleteCharAt(sb.length() - 1);;
        }
    }
}