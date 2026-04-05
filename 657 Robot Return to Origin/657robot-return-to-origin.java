class Solution {
    public boolean judgeCircle(String moves) {
        int l = moves.length();
        int countR = l - moves.replace("R", "").length();
        countR -= l - moves.replace("L", "").length();
        int countU = l - moves.replace("U", "").length();
        countU -= l - moves.replace("D", "").length();
        return countR == 0 && countU == 0? true : false;
    }
}