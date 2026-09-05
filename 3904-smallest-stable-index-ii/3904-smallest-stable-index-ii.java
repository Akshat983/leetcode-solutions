class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[nums.length];
        int max = nums[0];
        for(int i = 0; i < n; i++) {
            if(max < nums[i]) {
                max = nums[i];
            }
            score[i] = max;
        }
        int min = nums[n-1];
        for(int i = n-1; i >= 0; i--) {
            if(min > nums[i]) {
                min = nums[i];
            }
            score[i] = score[i] - min;
        }
        for(int i = 0; i < n; i++) {
            if(score[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}