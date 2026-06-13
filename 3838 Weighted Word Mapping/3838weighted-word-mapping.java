class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder("");
        for(String st : words) {
            int sum = 0;
            for(int i = 0; i < st.length(); i++) {
                sum += weights[st.charAt(i) - 'a'];
            }
            sum = sum%26;
            sb = sb.append((char)('z' - sum));
        }
        return sb.toString();
    }
}