class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') ones++;
        }
        List<int[]> b = new ArrayList<>();
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == '0') {
                int j = i;
                while (j < n && s.charAt(j) == '0') j++;
                b.add(new int[]{i, j - 1});
                i = j;
            } else {
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (b.size() < 2) {
            for (int i = 0; i < queries.length; i++) ans.add(ones);
            return ans;
        }
        int m = b.size();
        int[] adj = new int[m - 1];
        for (int i = 0; i < m - 1; i++) {
            int l1 = b.get(i)[1] - b.get(i)[0] + 1;
            int l2 = b.get(i + 1)[1] - b.get(i + 1)[0] + 1;
            adj[i] = l1 + l2;
        }
        for (int[] q : queries) {
            int ql = q[0], qr = q[1];

            int f = findFirst(b, ql);
            int l = findLast(b, qr);

            if (f == -1 || l == -1 || f >= l) {
                ans.add(ones);
                continue;
            }
            int fl = b.get(f)[1] - Math.max(b.get(f)[0], ql) + 1;
            int ll = Math.min(b.get(l)[1], qr) - b.get(l)[0] + 1;
            int max = 0;

            if (f + 1 == l) {
                max = fl + ll;
            } else {
                int nxt = b.get(f + 1)[1] - b.get(f + 1)[0] + 1;
                max = Math.max(max, fl + nxt);
                int prv = b.get(l - 1)[1] - b.get(l - 1)[0] + 1;
                max = Math.max(max, prv + ll);

                for (int i = f + 1; i < l - 1; i++) {
                    max = Math.max(max, adj[i]);
                }
            }
            ans.add(ones + max);
        }

        return ans;
    }

    private int findFirst(List<int[]> b, int ql) {
        int l = 0, r = b.size() - 1, res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (b.get(mid)[1] >= ql) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private int findLast(List<int[]> b, int qr) {
        int l = 0, r = b.size() - 1, res = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (b.get(mid)[0] <= qr) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
