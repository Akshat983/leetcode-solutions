class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int i = 0;
        int max = Integer.MIN_VALUE;
        while(i < nums.length) {
            sum += nums[i];
            if(max < sum) {
                max = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
            i++;
        }
        return max;
    }
}