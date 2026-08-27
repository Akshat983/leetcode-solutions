class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long MOD = 1_000_000_007L;
        int n = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[n];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++) {
            int l = 0;
            int r = i-1;

            while (l <= r) {
                long pro = (long) arr[l] * arr[r];
                if(pro == arr[i]) {
                    if(arr[l] == arr[r]) {
                        dp[i] = (dp[i] + dp[l] * dp[r]) % MOD;
                    }
                    else {
                        dp[i] = (dp[i] + dp[l] * dp[r] * 2) % MOD;
                    }
                    l++;
                    r--;
                }
                else if(pro < arr[i]) {
                    l++;
                }
                else {
                    r--;
                }
            }
        }

        long ans = 0;
        for(long i : dp) {
            ans = (ans + i) % MOD;
        }
        return (int) ans;
    }
}