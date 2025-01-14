class Solution {
    public int firstMissingPositive(int[] nums) {
        cyclicSort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1)
            return i+1;
        }
        return nums.length+1;
    }

    static void swap(int[] ar, int first, int second) {
        int temp = ar[first];
        ar[first] = ar[second];
        ar[second] = temp;
    }

    static void cyclicSort(int[] ar) {
        int i = 0;
        while (i < ar.length) {
            int correct = ar[i] - 1;
            if(ar[i] > 0 && ar[i] < ar.length && ar[i] != ar[correct]) {
                swap(ar, i, correct);
            }
            else {
                i++;
            }
        }
    }
}