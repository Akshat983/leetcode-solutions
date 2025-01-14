class Solution {
    public int missingNumber(int[] nums) {
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    void cyclicSort(int[] ar) {
        int i = 0;
        while (i < ar.length) {
            if(ar[i] < ar.length && ar[i] != ar[ar[i]]) {
                swap(ar, i, ar[i]);
            }
            else {
                i++;
            }
        }
    }

    void swap(int[] ar, int first, int second) {
        int temp = ar[first];
        ar[first] = ar[second];
        ar[second] = temp;
    }
}