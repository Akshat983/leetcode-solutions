class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] stack = new int[temp.length];
        int[] ans = new int[temp.length];
        int j = temp.length-1;
        int top = 0;
        int k = temp.length-1;
        ans[k--] = 0;
        stack[top] = j;
        j--;
        while(j >= 0) {
                for(int i = top; i >= 0; i--) {
                    if(temp[stack[i]] > temp[j]) {
                        ans[k--] = stack[i] - j;
                        stack[++top] = j;
                        break;
                    }
                    else {
                        top--;
                        if(top == -1) {
                            ans[k--] = 0;
                            stack[++top] = j;
                            break;
                        }
                    }
                }
                j--;
            
        }
        return ans;
    }
}