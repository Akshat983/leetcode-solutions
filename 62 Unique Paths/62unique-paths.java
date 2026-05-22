class Solution {
    public int uniquePaths(int m, int n) {
        int t = m + n - 2;
        int min = Math.min(m, n) - 1;
        long ans = 1;
        int j = 1;
        for (int i = t; i > t - min; i--) {
            ans = ans * i / j;
            j++;
        }
        return (int)ans;
    }
}