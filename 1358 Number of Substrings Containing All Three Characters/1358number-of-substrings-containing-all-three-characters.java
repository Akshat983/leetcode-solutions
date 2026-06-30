class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int lA = -1, lB = -1, lC = -1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') lA = i;
            else if (ch == 'b') lB = i;
            else if (ch == 'c') lC = i;
            if (lA != -1 && lB != -1 && lC != -1) {
                res += Math.min(lA, Math.min(lB, lC)) + 1;
            }
        }
        return res;
    }
}
