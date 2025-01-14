class Solution {
    public int[] findErrorNums(int[] nums) {
        cyclicSort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1)
            return new int[] {nums[i], i+1};
        }
        return new int[] {-1, -1};
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
            if(ar[i] != ar[correct]) {
                swap(ar, i, correct);
            }
            else {
                i++;
            }
        }
    }
}