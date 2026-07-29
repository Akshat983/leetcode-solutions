class Solution {
    public String removeDuplicates(String s) {
        char[] ch = new char[s.length()];
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(j == 0) {
                ch[j++] = s.charAt(i);
                continue;
            }
            else if(j > 0) {
                if(ch[j-1] == s.charAt(i)) {
                    j--;
                }
                else ch[j++] = s.charAt(i);
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < j; i++) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}