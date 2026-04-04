class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int col = encodedText.length()/rows;
        StringBuilder dec = new StringBuilder("");
        int i = 0;int j = 0;
        while(i < col) {
            j = i;
            while(j < encodedText.length()) {
                dec.append(encodedText.charAt(j));
                j+=col+1;;
            }
            i++;
        }
        return dec.toString().stripTrailing();
    }
}