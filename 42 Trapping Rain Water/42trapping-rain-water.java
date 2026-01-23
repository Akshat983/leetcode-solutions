import java.util.Arrays;

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
        }
        int leftWater = calculateWater(height, 0, maxIndex, 1);
        int rightWater = calculateWater(height, height.length - 1, maxIndex, -1);
        return leftWater + rightWater;
    }
    public int calculateWater(int[] h, int start, int end, int direction) {
        int total = 0;
        int i = start;
        while (i != end) {
            int j = i + direction;
            int sub = 0;
            boolean foundWall = false;
            while (j != end + direction) {
                if (h[j] < h[i]) {
                    sub += h[j];
                } else {
                    total += (Math.abs(j - i) - 1) * h[i] - sub;
                    i = j;
                    foundWall = true;
                    break;
                }
                j += direction;
            }
            if (!foundWall) break;
        }
        return total;
    }
}