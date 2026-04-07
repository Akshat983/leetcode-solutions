class Solution {
    public int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(binary);
        sb.reverse();
        for(int i = sb.length(); i < 32; i++) {
            sb.append("0");
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}