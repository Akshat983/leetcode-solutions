class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int col = matrix[0].length;
        int[] height = new int[col];
        int area = 0;

        for (char[] row : matrix) {
            for (int i = 0; i < col; i++) {
                height[i] = (row[i] == '1') ? height[i] + 1 : 0;
            }
            area = Math.max(area, maxR(height));
        }
        return area;
    }
    public int maxR(int[] h) {
        int max = 0;
        int[] st = new int[h.length + 1]; 
        int top = -1;
        for (int i = 0; i <= h.length; i++) {
            int cur = (i == h.length ? 0 : h[i]);
            while (top != -1 && cur < h[st[top]]) {
                int height = h[st[top--]];
                int width = (top == -1) ? i : i - st[top] - 1;
                max = Math.max(max, height * width);
            }
            st[++top] = i;
        }
        return max;
    }
}
