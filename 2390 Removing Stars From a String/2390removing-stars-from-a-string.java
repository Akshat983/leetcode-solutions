class Solution {
    public String removeStars(String s) {
        int l = s.length();
        char[] st = new char[l];
        int top = -1;
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i++);
            if(ch >= 'a' && ch <= 'z') st[++top] = ch;
            else --top;
        }
        StringBuilder ans = new StringBuilder("");
        for( int j = 0; j <= top; j++) {
            ans.append(st[j]);
        }
        return ans.toString();
    }
}