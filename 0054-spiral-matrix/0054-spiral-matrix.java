class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1, left = 0;
        List<Integer> ans = new ArrayList<>();
        while(top <= bottom && right >= left) {
            for(int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top += 1;
            for(int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right -= 1;
            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
            bottom -= 1;
            }
            if(right >= left) {
                for(int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
            left += 1;
            }
        }
        return ans;
    }
}