class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0, j = 0;
        int max = 0;
        while(i < nums.length && j < nums.length) {
            if(nums[j] == 1) {
                j++;
                if(j == nums.length) {
                    if(max < j-i) max = j-i;
                }
            }
            else{
                if(j-i > max) max = j-i;
                j++;
                i = j;
            }
        }
        return max;
    }
}