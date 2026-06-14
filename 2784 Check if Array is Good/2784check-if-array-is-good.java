import java.util.*;

class Solution {
    public boolean isGood(int[] nums) {
        int n = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(n < nums[i]) {
                n = nums[i];
            }
        }
        if (nums.length != n + 1) return false;     
        int[] count = new int[n + 1];
        for (int x : nums) {
            if (x < 1 || x > n) return false;       
            count[x]++;
        }
        for (int i = 1; i < n; i++) {
            if (count[i] != 1) return false;        
        }
        return count[n] == 2;                         
    }
}
