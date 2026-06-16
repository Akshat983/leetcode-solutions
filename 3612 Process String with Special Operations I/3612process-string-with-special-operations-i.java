class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                sb = sb.append(s.charAt(i));
            }
            else if(s.charAt(i) == '*') {
                if(sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
            }
            else if(s.charAt(i) == '#'){
                sb = sb.append(sb);
            }
            else{
                sb = sb.reverse();
            }
            i++;
        }
        return sb.toString();
    }
}