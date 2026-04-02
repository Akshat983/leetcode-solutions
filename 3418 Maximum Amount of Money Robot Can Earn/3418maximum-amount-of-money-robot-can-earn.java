class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length, m = coins[0].length;
        Integer[][][] dp = new Integer[n][m][3];
        return maxcell(coins, dp, n - 1, m - 1, 0);
    }

    int maxcell(int[][] coins, Integer[][][] dp, int r, int c, int rob) {

        if (r < 0 || c < 0) return Integer.MIN_VALUE;

        if (dp[r][c][rob] != null) return dp[r][c][rob];

        if (r == 0 && c == 0) {
            if (coins[0][0] >= 0) return coins[0][0];
            return (rob < 2) ? 0 : coins[0][0];
        }

        int fromTop = maxcell(coins, dp, r - 1, c, rob);
        int fromLeft = maxcell(coins, dp, r, c - 1, rob);

        int res = Integer.MIN_VALUE;

        if (coins[r][c] >= 0) {
            res = Math.max(fromTop, fromLeft) + coins[r][c];
        } else {
            if (rob < 2) {
                int skipTop = maxcell(coins, dp, r - 1, c, rob + 1);
                int skipLeft = maxcell(coins, dp, r, c - 1, rob + 1);
                res = Math.max(skipTop, skipLeft);
            }
            int take = Math.max(fromTop, fromLeft) + coins[r][c];
            res = Math.max(res, take);
        }

        return dp[r][c][rob] = res;
    }
}