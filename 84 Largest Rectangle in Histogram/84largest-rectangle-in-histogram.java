class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int max = 0;
        for(int i = 1; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                max = getMax(heights, stack, max, i);
            }
            stack.push(i);
        }

        int end = heights.length;
        while(!stack.isEmpty()) {
            max = getMax(heights, stack, max, end);
        }

        return max;
    }

    private int getMax(int[] heights, Stack<Integer> stack, int max, int i) {
        int area;
        int top = stack.pop();

        if(stack.isEmpty()) {
            area = heights[top] * i;
        }
        else {
            area = heights[top] * (i - 1 - stack.peek());
        }

        return Math.max(max, area);
    }
}