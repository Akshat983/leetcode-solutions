class Solution {
    public int maxJumps(int[] arr, int d) {
        int[] dp = new int[arr.length];
        int ans = 1;
        for(int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, dfs(i, dp, arr, d));
        }
        return ans;
    }
    public int dfs(int id, int[] dp, int[] arr, int d) {
        if(dp[id] != 0) {
            return dp[id];
        }
        int m = 1;
        int n = arr.length;
        for(int i = id+1; i <= id+d && i < n; i++) {
            if(arr[i] >= arr[id]) break;
            m = Math.max(m, 1+dfs(i, dp, arr, d));
        }
        for(int i = id-1; i >= id-d && i >= 0; i--) {
            if(arr[i] >= arr[id]) break;
            m = Math.max(m, 1+dfs(i, dp, arr, d));
        }
        dp[id] = m;
        return m;
    }
}