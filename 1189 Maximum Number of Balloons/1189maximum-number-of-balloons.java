class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] c = new int[5];

        for (char ch : text.toCharArray()) {
            if (ch == 'b') c[0]++;
            else if (ch == 'a') c[1]++;
            else if (ch == 'l') c[2]++;
            else if (ch == 'o') c[3]++;
            else if (ch == 'n') c[4]++;
        }

        c[2] /= 2;
        c[3] /= 2;

        int ans = c[0];
        for (int i = 1; i < 5; i++) {
            ans = Math.min(ans, c[i]);
        }

        return ans;
    }
}