class Solution {
    public int maxArea(int[] height) {
        int maxA = 0;
        int l = height.length;
        int i = 0, j = l-1;
        while(i <= j) {
            int area = (j-i) * Math.min(height[i], height[j]);
            if(area > maxA) { 
                maxA = area;
            }
            if(height[i]<height[j]) i++;
            else j--;
        }
        return maxA;
    }
}