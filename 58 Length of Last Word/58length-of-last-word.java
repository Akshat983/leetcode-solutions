class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int a=s.lastIndexOf(' ');
        String ss=s.substring(a+1);
        return ss.length();
    }
}