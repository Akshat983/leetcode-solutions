import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rows = grid.size();
        int cols = grid.get(0).size();
        int[][] dp = new int[rows][cols];
        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(0, 0, grid, health, dp);
    }

    private boolean dfs(int r, int c, List<List<Integer>> grid, int h, int[][] dp) {
        h -= (grid.get(r).get(c) == 1 ? 1 : 0);
        if (h <= 0) return false;
        if (r == grid.size() - 1 && c == grid.get(0).size() - 1) return true;

        if (h <= dp[r][c]) return false;
        dp[r][c] = h;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nc >= 0 && nr < grid.size() && nc < grid.get(0).size()) {
                if (dfs(nr, nc, grid, h, dp)) return true;
            }
        }
        return false;
    }
}
