class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st.push(ch);
                if(st.size() > s.length()/2) return false;
            }
            else {
                if(st.isEmpty()) {
                    return false;
                }
                char cc = st.peek();
                if(cc == '[' && ch == ']') st.pop();
                else if(cc == '(' && ch == ')') st.pop();
                else if(cc == '{' && ch == '}') st.pop();
                else return false;
            }
            i++;
        }
        if(st.isEmpty()) {
            return true;
        }
        return false;
    }
}