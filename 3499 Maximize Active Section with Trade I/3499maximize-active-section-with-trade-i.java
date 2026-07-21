class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') ones++;
        }
        String pad = "1" + s + "1";
        List<Integer> blocks = new ArrayList<>();
        int len = 0;
        for (char ch : pad.toCharArray()) {
            if (ch == '0') {
                len++;
            } else if (len > 0) {
                blocks.add(len);
                len = 0;
            }
        }
        if (blocks.size() < 2) {
            return ones;
        }
        int max = 0;
        for (int i = 0; i < blocks.size() - 1; i++) {
            int sum = blocks.get(i) + blocks.get(i + 1);
            max = Math.max(max, sum);
        }
        return ones + max;
    }
}
