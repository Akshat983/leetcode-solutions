class Solution {
    public int candy(int[] ratings) {
        int total = 0;
        int l = ratings.length;
        int[] can = new int[l];
        for(int i = 0; i < l; i++) {
            can[i] = 1;
        }
        for(int i = 1; i < l; i++) {
            if(ratings[i] > ratings[i-1]) {
                can[i] = can[i-1] +1;
            }
        }
        for(int i = l-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                can[i] = Math.max(can[i], can[i+1]+1);
            }
        }
        for(int i = 0; i < l; i++) {
            total += can[i];
        }
        return total;
    }
}