class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int c0 = 0;
        int c1 = 0;
        if(s1.charAt(0) != s2.charAt(0)) {
            c0=1;
            if(s1.charAt(0) == s2.charAt(2) && s2.charAt(0) == s1.charAt(2)) {}
            else {
                return false;
            }
        }
        if(s1.charAt(1) != s2.charAt(1)) {
            c1 = 1;
            if(s1.charAt(1) == s2.charAt(3) && s2.charAt(1) == s1.charAt(3)) {}
            else {
                return false;
            }
        }
        if(c0 == 0) {
            if(s1.charAt(2) != s2.charAt(2)) {
                return false;
            }
        }
        if(c1 == 0) {
            if(s1.charAt(3) != s2.charAt(3)) {
                return false;
            }
        }
        return true;
    }
}