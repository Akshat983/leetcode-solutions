class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char cur = res.charAt(0);
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == cur) {
                    count++;
                } else {
                    sb.append(count).append(cur);
                    cur = res.charAt(j);
                    count = 1;
                }
            }
            sb.append(count).append(cur);
            res = sb.toString();
        }
        return res;
    }
}
