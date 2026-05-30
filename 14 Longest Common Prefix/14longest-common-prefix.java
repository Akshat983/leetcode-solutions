class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }
        
        int prefixLen = 0;
        for (int i = 0; i < minLen; i++) {
            char ch = strs[0].charAt(i);
            for (String s : strs) {
                if (s.charAt(i) != ch) {
                    return strs[0].substring(0, prefixLen);
                }
            }
            prefixLen++;
        }
        return strs[0].substring(0, prefixLen);
    }
}
