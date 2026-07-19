class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        boolean[] seen = new boolean[26];
        for(int i = 0; i < s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }
        List<Character> st = new ArrayList<>();
        int top = -1;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (seen[ch - 'a']) continue;
            if (st.isEmpty()){
                st.add(ch);
                seen[ch - 'a'] = true;
                top = 0;
            } else {
                while (top >= 0 &&
                       ch < st.get(top) &&
                       last[st.get(top) - 'a'] > i){
                    seen[st.get(top) - 'a'] = false;
                    st.remove(top);
                    top--;
                }
                st.add(ch);
                seen[ch - 'a'] = true;
                top++;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : st) {
            ans.append(ch);
        }
        return ans.toString();
    }
}