class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int ans = Integer.MAX_VALUE;
        for(int k = 0; k < n; k++) {
            int cost = k;
            for(int i = 0; i < n/2; i++) {
                char a = s.charAt((i+k) % n);
                char b = s.charAt((n-1-i+k) % n);

                int diff = Math.abs(a - b);

                cost += Math.min(diff, 26 - diff);
            }
            ans = Math.min(ans, cost);
        }
        return ans;
    }
}