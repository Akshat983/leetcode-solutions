class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && arr[j][0] == arr[i][0]) j++;
            int size = j - i;
            if (size > 1) {
                for (int k = i; k < j; k++) {
                    int currIdx = arr[k][1];
                    int prevIdx = arr[(k - 1 >= i ? k - 1 : j - 1)][1];
                    int nextIdx = arr[(k + 1 < j ? k + 1 : i)][1];
                    int d1 = Math.abs(currIdx - prevIdx);
                    int d2 = Math.abs(currIdx - nextIdx);
                    int dist1 = Math.min(d1, n - d1);
                    int dist2 = Math.min(d2, n - d2);
                    ans[currIdx] = Math.min(dist1, dist2);
                }
            }
            i = j;
        }
        List<Integer> res = new ArrayList<>();
        for (int q : queries) {
            res.add(ans[q]);
        }
        return res;
    }
}