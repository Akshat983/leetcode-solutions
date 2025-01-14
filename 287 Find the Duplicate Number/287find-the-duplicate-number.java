class Solution {
    public int findDuplicate(int[] nums) {
        cyclicSort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1)
            return nums[i];
        }
        return -1;
        
    }

    static void cyclicSort(int[] ar) {
        int i = 0;
        while (i < ar.length) {
            int correct = ar[i] - 1;
            if(ar[i] != ar[correct]) {
                int temp = ar[i];
                ar[i] = ar[correct];
                ar[correct] = temp;
            }
            else {
                i++;
            }
        }
    }
}