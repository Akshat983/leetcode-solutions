class Solution {
    public int maxProduct(int[] nums) {
        int max = 0;
        int smax = 0;
        for(int i : nums) {
            if(i > max) {
                smax = max;
                max = i;
            }
            else {
                if(i > smax) smax = i;
            }
        }
        return (max-1)*(smax-1);
    }
}