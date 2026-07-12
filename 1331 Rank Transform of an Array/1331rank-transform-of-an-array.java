import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0) return new int[0];
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int[] unique = new int[n];
        int m = 0;
        unique[m++] = sorted[0];
        for (int i = 1; i < n; i++) {
            if (sorted[i] != sorted[i - 1]) {
                unique[m++] = sorted[i];
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Arrays.binarySearch(unique, 0, m, arr[i]) + 1; 
        }
        return ans;
    }
}
