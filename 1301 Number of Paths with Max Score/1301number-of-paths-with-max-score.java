class Solution {
    int MOD = 1_000_000_007;
    int[][] maxScore;
    int[][] ways;
    char[][] b;
    int n;

    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();
        b = new char[n][n];
        for (int i = 0; i < n; i++) {
            b[i] = board.get(i).toCharArray();
        }
        maxScore = new int[n][n];
        ways = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(maxScore[i], -2);
        }
        int[] res = dfs(n-1, n-1);
        if (res[0] < 0) return new int[]{0,0};
        return res;
    }

    int[] dfs(int r, int c) {
        if (r < 0 || c < 0 || b[r][c] == 'X') return new int[]{-1,0};
        if (r == 0 && c == 0) return new int[]{0,1};
        if (maxScore[r][c] != -2) return new int[]{maxScore[r][c], ways[r][c]};
        int best = -1, count = 0;
        int[][] dirs = {{-1,0},{0,-1},{-1,-1}};
        for (int[] d : dirs) {
            int[] res = dfs(r+d[0], c+d[1]);
            if (res[0] < 0) continue;
            if (res[0] > best) {
                best = res[0];
                count = res[1];
            } else if (res[0] == best) {
                count = (count + res[1]) % MOD;
            }
        }
        if (best < 0) {
            maxScore[r][c] = -1;
            ways[r][c] = 0;
            return new int[]{-1,0};
        }
        int val = (b[r][c] == 'S' || b[r][c] == 'E') ? 0 : b[r][c] - '0';
        maxScore[r][c] = best + val;
        ways[r][c] = count;
        return new int[]{maxScore[r][c], ways[r][c]};
    }
}
