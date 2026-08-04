class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        int max = Integer.MIN_VALUE;
        while(i < j) {
            int sum = nums[i++] + nums[j--];
            if(max < sum) max = sum;
        }
        return max;
    }
}