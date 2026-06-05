class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while (result.length() > 0 && result.charAt(result.length() - 1) > digit && k > 0) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            result.append(digit);
        }
        
        while (k > 0 && result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }
        
        int nonZeroIndex = 0;
        while (nonZeroIndex < result.length() && result.charAt(nonZeroIndex) == '0') {
            nonZeroIndex++;
        }
        
        String finalResult = result.substring(nonZeroIndex);
        
        return finalResult.isEmpty() ? "0" : finalResult;
    }
}
