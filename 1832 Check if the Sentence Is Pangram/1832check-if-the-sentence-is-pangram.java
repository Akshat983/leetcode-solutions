class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] occur = new boolean[26];
        for (char ch : sentence.toCharArray()) {
            occur[ch-'a'] = true;
        }
        for(int i = 0; i < 26; i++) {
            if(!occur[i]) return false;
        }
        return true;
    }
}