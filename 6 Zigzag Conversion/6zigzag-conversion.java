class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder result = new StringBuilder();
        int cycleLen = 2 * numRows - 2;

        for (int r = 0; r < numRows; r++) {
            for (int i = r; i < s.length(); i += cycleLen) {
                result.append(s.charAt(i));
                int diag = i + cycleLen - 2 * r;
                if (r != 0 && r != numRows - 1 && diag < s.length()) {
                    result.append(s.charAt(diag));
                }
            }
        }
        return result.toString();
    }
}
