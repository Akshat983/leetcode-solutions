class Solution {
    public int minRotations(String s) {
        int ans = 0;
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            int target = s.charAt(i) - '0';
            int diff = Math.abs(cur - target);
            ans += Math.min(diff, 10 - diff);
            cur = target;
        }
        return ans;
    }
}