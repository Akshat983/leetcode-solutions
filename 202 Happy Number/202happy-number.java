class Solution {
    public boolean isHappy(int n) {
        int fp = n, sp = n;
        do {
            sp = sqdig(sp);
            fp = sqdig(sqdig(fp));
        } while(fp != sp);
        if(sp == 1) return true;
        return false;
    }
    public int sqdig(int n) {
        int pro = 0;
        while(n > 0) {
            int d = n%10;
            pro += d * d;
            n = n/10;
        }
        return pro;
    }
}