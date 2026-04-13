class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int i = start, j = start;;
        int mini = Integer.MAX_VALUE, minj = Integer.MAX_VALUE;
        while(i < nums.length) {
            if(target == nums[i]){ mini = i-start; break;}
            i++;
        }
        while(j >= 0) {
            if(target == nums[j]){ minj = start-j; break;}
            j--;
        }
        return Math.min(mini, minj);
    }
}