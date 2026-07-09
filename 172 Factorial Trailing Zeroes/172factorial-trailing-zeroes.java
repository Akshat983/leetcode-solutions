class Solution {
    public int trailingZeroes(int n) {
        int t = 0;
        while(n > 0) {
            n = n/5;
            t+=n;
        }
        return t;
    }
}