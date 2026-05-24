class Solution {
    public String makeGood(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (top >= 0 && Math.abs(stack[top] - ch) == 32) {
                top--;
            } else {
                stack[++top] = ch;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            ans.append(stack[i]);
        }
        return ans.toString();
    }
}
