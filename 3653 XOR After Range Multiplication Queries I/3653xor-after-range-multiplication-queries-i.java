class Solution {
    static final int MOD = 1000000007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        long[] mult = new long[n];
        for (int i = 0; i < n; i++) mult[i] = 1;

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            for (int i = l; i <= r; i += k) {
                mult[i] = (mult[i] * v) % MOD;
            }
        }

        int xor = 0;

        for (int i = 0; i < n; i++) {
            long val = (nums[i] * mult[i]) % MOD;
            xor ^= (int) val;
        }

        return xor;
    }
}