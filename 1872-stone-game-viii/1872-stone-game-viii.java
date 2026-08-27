class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        int[] preSum = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += stones[i];
            preSum[i] = sum;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        return solve(preSum, 1, dp);
    }

    public int solve(int[] ar, int i, int[] dp) {
        int n = ar.length;

        if (i == n - 1) {
            return ar[n - 1];
        }

        if (dp[i] != Integer.MIN_VALUE) {
            return dp[i];
        }

        int take = ar[i] - solve(ar, i + 1, dp);
        int skip = solve(ar, i + 1, dp);

        return dp[i] = Math.max(take, skip);
    }
}