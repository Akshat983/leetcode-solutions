class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int[] vals = prefix.clone();
        java.util.Arrays.sort(vals);

        Fenwick bit = new Fenwick(vals.length + 2);
        long ans = 0;

        for (int x : prefix) {
            int idx = lowerBound(vals, x) + 1;
            ans += bit.query(idx - 1);
            bit.update(idx, 1);
        }

        return (int) ans;
    }

    private int lowerBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < x) l = m + 1;
            else r = m;
        }
        return l;
    }

    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void update(int i, int val) {
            while (i < bit.length) {
                bit[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= i & -i;
            }
            return sum;
        }
    }
}