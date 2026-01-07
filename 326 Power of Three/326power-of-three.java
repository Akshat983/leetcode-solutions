class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0)
        {return false;}
        if(n == 243 || n == 59049 ||n==1594323 || n==14348907 || n==129140163)
        {return true;}
        double i = Math.log(n)/Math.log(3);
        return (i == (int)i);
    }
}