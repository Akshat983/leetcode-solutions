class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long ans = 0;

        for(int i = 0; i < n; i++) {
            long x = nums[i];
            if(i < (n) / 2)
                ans -= x * x;
            else
                ans += x * x;
        }

        return ans;
    }
}