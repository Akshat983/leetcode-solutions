class Solution {
    public int totalNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        return solve(n, 0, board, 0);
    }

    int solve(int n, int ans, char[][] board, int r) {
        if(r == n) {
            return 1;
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(isSafe(board, r, i)) {
                board[r][i] = 'Q';
                count +=solve(n, ans, board, r+1);
                board[r][i] = '.';
            }
        }
        return count;
    }

    boolean isSafe(char[][] board, int r, int c) {
    int n = board.length;
    for (int i = 0; i < r; i++) {
        if (board[i][c] == 'Q') return false;
    }
    for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
        if (board[i][j] == 'Q') return false;
    }
    for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
        if (board[i][j] == 'Q') return false;
    }

    return true;
}

}