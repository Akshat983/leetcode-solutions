class Solution {
    public int minimumPushes(String word) {
        int  l = word.length();
        int c = 0;
        int i = 1;
        while(l > 0) {
            if(l <= 8) {
                c += l*i;
                l = 0;
                i += 1;
            }
            else {
                c += i*8;
                l = l-8;
                i += 1;
            }
        }
        return c;
    }
}