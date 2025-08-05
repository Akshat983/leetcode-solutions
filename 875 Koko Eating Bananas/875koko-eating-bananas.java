class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int max = piles[0];
        for(int i = 1; i < piles.length; i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }
        int high = max;
        int mid = 0;
        while(low < high) {
            mid = low + (high - low)/2;
            if(hours(piles, mid) <= h) {
                high = mid;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }
    public int hours(int[] piles, int banana) {
        int hrs = 0;
        for(int i = 0; i < piles.length; i++) {
            hrs += (piles[i] + banana - 1) / banana;
        }
        return hrs;
    }
}