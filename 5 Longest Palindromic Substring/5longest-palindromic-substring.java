class Solution {
    String[][] mem;
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        mem = new String[n][n];
        return longPalin(s, 0, n - 1);
    }

    String longPalin(String s, int i, int j) {
        if (i > j) return "";
        if (i == j) return s.substring(i, i + 1);
        if (mem[i][j] != null) return mem[i][j];

        if (isPalin(s, i, j)) {
            return mem[i][j] = s.substring(i, j + 1);
        }

        String l = longPalin(s, i, j - 1);
        String r = longPalin(s, i + 1, j);

        return mem[i][j] = l.length() >= r.length() ? l : r;
    }

    boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}