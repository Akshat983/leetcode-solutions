class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(n, ans, board, 0);
        return ans;
    }
    void solve(int n, List<List<String>> ans, char[][] board, int r) {
        if(r == n) {
            ans.add(construct(board));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(isSafe(board, r, i)) {
                board[r][i] = 'Q';
                solve(n, ans, board, r+1);
                board[r][i] = '.';
            }
        }
    }

    List<String> construct(char[][] board) {
        
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            StringBuffer row = new StringBuffer("");
            for(int j = 0; j < board[0].length; j++) {
                row.append(board[i][j]);
            }
            ans.add(row.toString());
        }
        return ans;
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