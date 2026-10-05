class Solution {
    public int scoreOfParentheses(String s) {
        return helper(0, s.length() - 1, s);
    }

    public int helper(int st, int end, String s) {
        if (st > end) return 0;
        if (s.charAt(st) == '(' && s.charAt(end) == ')') {
            int balance = 0;
            for (int i = st; i <= end; i++) {
                if (s.charAt(i) == '(') balance++;
                else balance--;

                if (balance == 0) {
                    if (i == end) {
                        if (end == st + 1) return 1;
                        return 2 * helper(st + 1, end - 1, s);
                    }
                    else {
                        return helper(st, i, s) + helper(i + 1, end, s);
                    }
                }
            }
        }
        return 0;
    }
}