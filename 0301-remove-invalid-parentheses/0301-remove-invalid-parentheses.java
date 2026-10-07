class Solution {
    HashSet<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);

        int left = 0, right = 0;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                left++;
            } else if (sb.charAt(i) == ')') {
                if (left > 0) left--;
                else right++;
            }
        }

        remove(sb, 0, left, right);

        return new ArrayList<>(set);
    }

    public void remove(StringBuilder sb, int index, int left, int right) {
        if (left == 0 && right == 0) {
            if (isValid(sb))
                set.add(sb.toString());
            return;
        }

        for (int i = index; i < sb.length(); i++) {
            if (i > index && sb.charAt(i) == sb.charAt(i - 1))
                continue;

            if (right > 0 && sb.charAt(i) == ')') {
                sb.deleteCharAt(i);
                remove(sb, i, left, right - 1);
                sb.insert(i, ')');
            }

            if (left > 0 && sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                remove(sb, i, left - 1, right);
                sb.insert(i, '(');
            }
        }
    }

    public boolean isValid(StringBuilder sb) {
        int balance = 0;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                balance++;
            } else if (sb.charAt(i) == ')') {
                balance--;
                if (balance < 0) return false;
            }
        }

        return balance == 0;
    }
}