class Solution {
    public boolean contains(String p, char c, int s){
        return (p.indexOf(c, s)!=-1);
    }
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int max = 0;
        int l = 0, r = 0;
        while(r < s.length()) {
            String st = s.substring(l, r);
            char nxt = s.charAt(r);
            if(st.contains(String.valueOf(nxt))) {
                l++;
            }
            else {
                r++;
                max = Math.max(max, r-l);
            }
        }
        return max;
    }
}