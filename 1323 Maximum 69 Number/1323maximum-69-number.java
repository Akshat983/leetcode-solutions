class Solution {
    public int maximum69Number (int num) {
        int l = (int)Math.log10(num);
        int dig;
        int max = num;
        while(l >= 0) {
            dig = num/(int)Math.pow(10, l);
            num = num%(int)Math.pow(10, l);
            if(dig == 9) {
                l--;
                continue;
            }
            max = max + 3 * (int)Math.pow(10, l);
            break;
        }
        return max;
    }
}