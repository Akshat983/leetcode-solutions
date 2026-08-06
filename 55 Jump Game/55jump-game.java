class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        boolean[] achievable = new boolean[target+1];
        achievable[target] = true;
        for(int i = nums.length-1; i >= 0; i--){
            if(achievable[i]) continue;
            if(target <= nums[i]+i) {
                achievable[i] = true;
                target = i;
            }
        }
        return achievable[0];
    }
}