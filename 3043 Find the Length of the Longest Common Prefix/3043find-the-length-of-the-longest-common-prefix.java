import java.util.*;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        String[] s1 = new String[arr1.length];
        String[] s2 = new String[arr2.length];
        for (int i = 0; i < arr1.length; i++) s1[i] = Integer.toString(arr1[i]);
        for (int j = 0; j < arr2.length; j++) s2[j] = Integer.toString(arr2[j]);
        Arrays.sort(s1);
        Arrays.sort(s2);
        int i = 0, j = 0, ans = 0;
        while (i < s1.length && j < s2.length) {
            ans = Math.max(ans, commonPrefixLength(s1[i], s2[j]));
            if (s1[i].compareTo(s2[j]) < 0) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
    int commonPrefixLength(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int count = 0;
        for (int k = 0; k < len; k++) {
            if (a.charAt(k) == b.charAt(k)) count++;
            else break;
        }
        return count;
    }
}
