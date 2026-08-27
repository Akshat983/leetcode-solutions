class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] ex = new boolean[101];
        for(int i : nums) {
            ex[i] = true;
        }
        int n = k;
        while(n < 101) {
            if(! ex[n]) return n;
            n += k;
        }return n;
    }
}