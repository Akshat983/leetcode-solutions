class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int maxVal = 2048; 
        boolean[] pairs = new boolean[maxVal];
        
        for (int x : nums) {
            for (int y : nums) {
                pairs[x ^ y] = true;
            }
        }
        
        boolean[] triplets = new boolean[maxVal];
        for (int i = 0; i < maxVal; i++) {
            if (pairs[i]) {
                for (int z : nums) {
                    triplets[i ^ z] = true;
                }
            }
        }
        
        int count = 0;
        for (boolean valid : triplets) {
            if (valid) {
                count++;
            }
        }
        
        return count;
    }
}
