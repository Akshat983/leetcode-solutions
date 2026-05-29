class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int sum = 0;
            while(n > 0) {
                int t = n%10;
                sum += t;
                n = n/10;
                if(sum >= min) break;
            }
            if(sum < min) min = sum;
        }
        return min;
    }
}