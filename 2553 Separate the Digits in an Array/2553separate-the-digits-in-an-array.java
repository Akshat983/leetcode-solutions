class Solution {
    public int[] separateDigits(int[] nums) {
        int l = 0;
        for(int i : nums) {
            l += Math.log10(i) + 1;
        }
        int[] ans = new int[l];
        int j = 0;
        for(int i : nums) {
            for(char ch : Integer.toString(i).toCharArray()) {
                ans[j++] = ch - '0';
            }
        }
        return ans;
    }
}