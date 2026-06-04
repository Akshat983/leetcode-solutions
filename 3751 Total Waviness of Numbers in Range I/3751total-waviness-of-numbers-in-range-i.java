class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int n = num1; n <= num2; n++) {
            String s = String.valueOf(n);

            for (int i = 1; i < s.length() - 1; i++) {
                int prev = s.charAt(i - 1) - '0';
                int cur  = s.charAt(i) - '0';
                int next = s.charAt(i + 1) - '0';

                if ((cur > prev && cur > next) ||
                    (cur < prev && cur < next)) {
                    ans++;
                }
            }
        }

        return ans;
    }
}