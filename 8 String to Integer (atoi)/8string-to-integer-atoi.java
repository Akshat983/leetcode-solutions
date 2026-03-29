class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) {
            return 0;
        }
        
        int l = s.length();
        int i = 0;
        int sign = 1;
        long num = 0;
        if(s.charAt(0) == '+') {
            sign = 1;
            i++;
        }
        if(s.charAt(0) == '-') {
            sign = -1;
            i++;
        }
        int j = 0;
        while(i < s.length()) {
            if(s.charAt(i) > '9' || s.charAt(i) < '0') {
                break;
            }
            int digit = s.charAt(i) - '0';
            num = num*10 + digit;
            i++;
            if(num*sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if(num*sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)num*sign;
    }
}