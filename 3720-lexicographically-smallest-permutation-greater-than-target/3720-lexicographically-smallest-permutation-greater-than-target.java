class Solution {
    String res;
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        if(solve(new StringBuilder(""), target, 0, false, freq)) {
            return res;
        }
        return "";
    }

    public boolean solve(StringBuilder curr, String target, int i, boolean greater, int[] freq) {
        if(i == target.length()) {
            if(greater) {
                res = curr.toString();
                return true;
            }
            return false;
        }

        for(char ch = 'a'; ch <= 'z'; ch++) {
            if(freq[ch - 'a'] == 0) continue;

            if(!greater && ch < target.charAt(i)) continue;

            curr.append(ch);
            freq[ch - 'a']--;

            boolean isGreater = greater || ch > target.charAt(i);

            if(solve(curr, target, i + 1, isGreater, freq)) return true;

            curr.deleteCharAt(curr.length() - 1);
            freq[ch - 'a']++;
        }
        return false;
    }
}