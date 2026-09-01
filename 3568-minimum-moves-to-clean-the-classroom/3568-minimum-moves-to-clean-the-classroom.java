import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int sr = 0, sc = 0;
        List<int[]> litter = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    sr = i;
                    sc = j;
                } else if (ch == 'L') {
                    litter.add(new int[]{i, j});
                }
            }
        }
        int k = litter.size();
        if (k == 0) {
            return 0;
        }
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < k; i++) {
            litterId[litter.get(i)[0]][litter.get(i)[1]] = i;
        }
        int allMask = (1 << k) - 1;
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << k];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc, energy, 0, 0});
        visited[sr][sc][energy][0] = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int e = cur[2];
            int mask = cur[3];
            int moves = cur[4];
            if (mask == allMask) {
                return moves;
            }
            if (e == 0) {
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }
                int ne = e - 1;
                int nmask = mask;
                if (classroom[nr].charAt(nc) == 'L') {
                    int id = litterId[nr][nc];
                    nmask |= (1 << id);
                }
                if (classroom[nr].charAt(nc) == 'R') {
                    ne = energy;
                }
                if (!visited[nr][nc][ne][nmask]) {
                    visited[nr][nc][ne][nmask] = true;
                    queue.offer(new int[]{
                            nr, nc, ne, nmask, moves + 1
                    });
                }
            }
        }
        return -1;
    }
}