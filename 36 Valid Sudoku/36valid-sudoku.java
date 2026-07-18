class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            boolean[] used = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '1';
                if (used[num]) return false;
                used[num] = true;
            }
        }
        for (int j = 0; j < 9; j++) {
            boolean[] used = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '1';
                if (used[num]) return false;
                used[num] = true;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] used = new boolean[9];

                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        if (board[r][c] == '.') continue;

                        int num = board[r][c] - '1';
                        if (used[num]) return false;
                        used[num] = true;
                    }
                }
            }
        }

        return true;
    }
}