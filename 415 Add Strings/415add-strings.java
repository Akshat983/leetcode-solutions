class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;

        while (p1 >= 0 || p2 >= 0 || carry != 0) {
            int d1 = (p1 >= 0) ? num1.charAt(p1--) - '0' : 0;
            int d2 = (p2 >= 0) ? num2.charAt(p2--) - '0' : 0;

            int total = d1 + d2 + carry;
            carry = total / 10;
            res.append(total % 10);
        }

        return res.reverse().toString();
    }
}
