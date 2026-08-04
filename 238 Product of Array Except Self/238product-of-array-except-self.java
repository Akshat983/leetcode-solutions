class Solution {
    public int[] productExceptSelf(int[] nums) {
        int lpro = 1;
        int rpro = 1;
        int l = nums.length;
        int[] left = new int[l];
        int[] right = new int[l];
        int[] ans = new int[l];
        for(int i = 0; i < nums.length; i++) {
            left[i] = lpro;
            right[l-1-i] = rpro;
            lpro = lpro * nums[i];
            rpro = rpro * nums[l-1-i];
        }
        for(int i = 0; i < nums.length; i++){
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}