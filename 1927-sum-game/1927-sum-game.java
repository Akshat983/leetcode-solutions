class Solution {
    public boolean sumGame(String num) {
        int l = num.length();
        int ls = 0, rs = 0;
        int lq = 0, rq = 0;

        for (int i = 0; i < l; i++) {
            char c = num.charAt(i);
            if (i < l / 2) {
                if (c == '?') lq++;
                else ls += c - '0';
            } else {
                if (c == '?') rq++;
                else rs += c - '0';
            }
        }

        int q = lq + rq;
        if (q % 2 == 1) return true;

        int diff = ls - rs;
        int qDiff = rq - lq;

        return diff != qDiff * 9 / 2;
    }
}
