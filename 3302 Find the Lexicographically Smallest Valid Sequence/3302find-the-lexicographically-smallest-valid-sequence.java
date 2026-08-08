import java.util.*;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[m];
        Arrays.fill(suf, -1);

        int i = n - 1;
        int j = m - 1;

        while(i >= 0 && j >= 0) {
            if(word1.charAt(i) == word2.charAt(j)) {
                suf[j] = i;
                j--;
            }
            i--;
        }

        int[] ans = new int[m];

        i = 0;
        j = 0;
        boolean used = false;

        while(i < n && j < m) {

            if(word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                i++;
                j++;
            }
            else if(!used && (j == m - 1 || suf[j + 1] > i)) {
                ans[j] = i;
                used = true;
                i++;
                j++;
            }
            else {
                i++;
            }
        }

        if(j == m) {
            return ans;
        }

        return new int[0];
    }
}