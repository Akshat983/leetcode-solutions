class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        falane(ans, 0, 0, n, new StringBuilder());
        return ans;
    }
    public void falane(List<String> ans, int open, int close, int n, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            falane(ans, open + 1, close, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            falane(ans, open, close + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
