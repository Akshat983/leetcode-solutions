class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) sb.append("-");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        sb.append(num / den);
        num %= den;
        if (num == 0) return sb.toString();
        sb.append(".");
        StringBuilder frac = new StringBuilder();
        java.util.List<Long> remainders = new java.util.ArrayList<>();
        while (num != 0) {
            if (remainders.contains(num)) {
                int idx = remainders.indexOf(num);
                sb.append(frac.substring(0, idx));
                sb.append("(").append(frac.substring(idx)).append(")");
                return sb.toString();
            }
            remainders.add(num);
            num *= 10;
            frac.append(num / den);
            num %= den;
        }
        sb.append(frac);
        return sb.toString();
    }
}
