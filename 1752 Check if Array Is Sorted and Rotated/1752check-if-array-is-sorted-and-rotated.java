class Solution {
    public boolean check(int[] nums) {
        if(nums.length <= 2) return true;
        boolean good = true;
        int count = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] <= nums[i+1]) continue;
            else {
                count++;
            }
            if(count == 1) {
                if(nums[i+1] > nums[0] || nums[nums.length-1] > nums[0]){
                    good = false;
                }
                if(good == false) break;
            }
            if(count > 1){
                good = false;
                break;
            }
        }
        return good;
    }
}