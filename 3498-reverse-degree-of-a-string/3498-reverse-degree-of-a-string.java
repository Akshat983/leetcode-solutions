class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        int i = 1;
        for(char ch : s.toCharArray()) {
            total += i++ * (int)(26 - ch + 97);
        }
        return total;
    }
}