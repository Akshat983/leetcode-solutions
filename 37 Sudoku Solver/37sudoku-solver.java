class Solution {
    public void solveSudoku(char[][] board) {
        if(solve(board)) {
            display(board);
        }
        else {
            System.out.println("Can't solve");
        }
    }

    public void display(char[][] board) {
        for(char[] i : board) {
            System.out.println(Arrays.toString(i));
        }
    }

    public boolean solve(char[][] board) {
        int row = -1;
        int col = -1;
        boolean emptyleft = true;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == '.') {
                    row = i;
                    col = j;
                    emptyleft = false;
                    break;
                }
            }
            if(!emptyleft) break;
        }
        if(emptyleft) {
            return true;
        }
        for(int num = 49; num < 49+board.length; num++) {
            if(isSafe(board, row, col, (char)num)) {
                board[row][col] = (char)num;
                if(solve(board)) {
                    return true;
                }
                else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    public boolean isSafe(char[][] board, int row, int col, char num) {
        //check for row
        for(int i = 0; i < board.length; i++) {
            if(num == board[row][i]) {
                return false;
            }
        }
        //check for col
        for(int i = 0; i < board.length; i++) {
            if(num == board[i][col]) {
                return false;
            }
        }
        //check for matrix
        int n = (int)Math.sqrt(board.length);
        int rstart = row - row % n;
        int cstart = col - col % n;
        for(int r = rstart; r < rstart + n; r++) {
            for(int c = cstart; c < cstart + n; c++) {
                if(num == board[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }
}