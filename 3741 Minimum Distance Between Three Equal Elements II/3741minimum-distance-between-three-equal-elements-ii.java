class Solution {
    public int minimumDistance(int[] nums) {
        int[] hash = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            hash[nums[i]-1]++;
        }
        Boolean in = false;
        int min = Integer.MAX_VALUE;;
        for(int i = 0; i < nums.length; i++) {
            if(hash[i] >= 3) {
                min = Math.min(min, calculate(nums, i+1));
                in = true;
            }
        }
        if(!in) return -1;
        return min;
    }
    public int calculate(int[] nums, int num) {
        int[] l = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == num) {
                l[j++] = i;
            }
        }
        int minidx = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < j-2; i++) {
            int cal = l[i+2] - l[i];
            if(cal < min) {
                minidx = l[i];
                min = cal;
            }
        }
        return 2*min;
    }
}