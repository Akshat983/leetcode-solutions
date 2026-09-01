class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        int[] suf = new int[n];
        for(int i = 1; i < n; i++) {
            pre[i] = gcd(pre[i - 1], nums[i]);
        }
        suf[n-1] = nums[n-1];

        for(int i = n-2; i >= 0; i--) {
            suf[i] = gcd(nums[i], suf[i+1]);
        }
        int ans = getScore(nums, pre, suf, -1);
        for(int remove = 0; remove < n; remove++) {
            ans = Math.max(ans, getScore(nums, pre, suf, remove));
        }
        return ans;
    }

    private int getScore(int[] nums, int[] pre, int[] suf, int remove) {
        int n = nums.length;
        if(n - (remove == -1? 0 : 1) <= 1) {
            return 0;
        }

        if (remove == -1) {
            int score = 0;
            for (int k = 0; k < n - 1; k++) {
                if (pre[k] == suf[k + 1]) {
                    score++;
                }
            }
            return score;
        }

        int m = n - 1;
        int[] arr = new int[m];
        for (int i = 0, j = 0; i < n; i++) {
            if (i != remove) {
                arr[j++] = nums[i];
            }
        }

        int[] p = new int[m];
        p[0] = arr[0];
        for (int i = 1; i < m; i++) {
            p[i] = gcd(p[i - 1], arr[i]);
        }

        int[] s = new int[m];
        s[m - 1] = arr[m - 1];
        for (int i = m - 2; i >= 0; i--) {
            s[i] = gcd(arr[i], s[i + 1]);
        }

        int score = 0;
        for (int k = 0; k < m - 1; k++) {
            if (p[k] == s[k + 1]) {
                score++;
            }
        }
        return score;
    }


    private int gcd (int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}