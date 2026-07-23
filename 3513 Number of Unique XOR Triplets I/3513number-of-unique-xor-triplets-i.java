class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return n;
        }
        int po2 = 1;
        while (po2 <= n) {
            po2 <<= 1;
        }
        
        return po2;
    }
}
