class Solution {

    public int minimumDistance(String word) {
        int n = word.length();
        Integer[][][] dp = new Integer[n][27][27];
        return solve(word, 0, 26, 26, dp);
    }

    private int solve(String word, int i, int f1, int f2, Integer[][][] dp) {
        if (i == word.length()) return 0;
        if (dp[i][f1][f2] != null) return dp[i][f1][f2];
        int curr = word.charAt(i) - 'A';
        int cost1 = distance(f1, curr) + solve(word, i + 1, curr, f2, dp);
        int cost2 = distance(f2, curr) + solve(word, i + 1, f1, curr, dp);

        return dp[i][f1][f2] = Math.min(cost1, cost2);
    }

    private int distance(int from, int to) {
        if (from == 26) return 0;
        int x1 = from / 6, y1 = from % 6;
        int x2 = to / 6, y2 = to % 6;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}