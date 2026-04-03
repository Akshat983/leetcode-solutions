class Solution {
    public int removeElement(int[] nums, int val) {
        int c = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                c++;
            }
        }
        int j = 0;
        int[] ar = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                ar[j++] = nums[i];
            }
        }
        for(int i = 0; i < nums.length; i ++) {
                nums[i] = ar[i];
        }
        return nums.length-c;
    }
}