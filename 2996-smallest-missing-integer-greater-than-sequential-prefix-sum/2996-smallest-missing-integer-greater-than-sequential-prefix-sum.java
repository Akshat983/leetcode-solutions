class Solution {
    public int missingInteger(int[] nums) {
        int a = nums[0];
        int sum = nums[0];
        int i;
        for(i = 1; i < nums.length; i++) {
            if(nums[i] != ++a) {
                break;
            }
            sum += nums[i];
        }
        Arrays.sort(nums); 
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] == sum) {
                sum++;
            }
        }
        return sum;
    }
}