class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int i = 0, j = 0;
        int dir = 1;
        int[] res = new int[r * c];

        for (int a = 0; a < r * c; a++) {
            res[a] = mat[i][j];

            if (dir == 1) { 
                if (j == c - 1) { 
                    i++;
                    dir = -1;
                } else if (i == 0) {
                    j++;
                    dir = -1;
                } else {
                    i--;
                    j++;
                }
            } else { 
                if (i == r - 1) {
                    j++;
                    dir = 1;
                } else if (j == 0) {
                    i++;
                    dir = 1;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}
