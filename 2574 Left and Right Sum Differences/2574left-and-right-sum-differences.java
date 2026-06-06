class Solution {
    public int[] leftRightDifference(int[] nums) {
        int ls = 0;
        int rs=0;
        for(int i:nums)
            rs+=i;
        int prev = 0;
        for(int i = 0; i<nums.length; i++) {
            ls = ls+prev;
            rs= rs-nums[i];
            prev = nums[i];
            nums[i] = Math.abs(ls-rs);
        }
        return nums;
    }
}