class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9*num) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        while(num-- > 0) {
            if(sum < 9) {
                ans.append(sum);
                sum = 0;
            }
            else {
                ans.append(9);
                sum -= 9;
            }
        }
        return ans.toString();
    }
}