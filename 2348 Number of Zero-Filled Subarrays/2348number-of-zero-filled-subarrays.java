class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long c = 0;
        long ans = 0;
        for(int i : nums) {
            if(i != 0 && c == 0) continue;
            if(i == 0) {
                c++;
            }
            else {
                ans += (c*(c+1))/2;
                c = 0;
            }
        }
        ans += c * (c + 1) / 2;
        return ans;
    }
}