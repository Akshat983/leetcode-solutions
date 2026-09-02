class Solution {
    public String[] largestString(int[] nums) {
        String[] ans1 = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            StringBuilder ans = new StringBuilder("");
            while(nums[i] > 0) {
                int ch = (int) (Math.log(nums[i]) / Math.log(2));
                ch = (ch < 26)? ch : 25;
                nums[i] -= (int)Math.pow(2, ch);
                ans.append((char)('a' + ch));
            }
            ans1[i] = ans.toString();
        }
        return ans1;
    }
}