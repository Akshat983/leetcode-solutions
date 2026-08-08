import java.util.Stack;

class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                st.push(ch);
            } 
            else { 
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    insertions++;
                }

                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    insertions++;
                }
            }
        }

        insertions += st.size() * 2;

        return insertions;
    }
}