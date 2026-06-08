class Solution {
    public double myPow(double x, int n) {
      
        long N = n;
    
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        return fastPow(x, N);
    }
    
    private double fastPow(double x, long n) {
    
        if (n == 0) return 1.0;
        if (n == 1) return x;

        if (n % 2 == 0) {
            return fastPow(x * x, n / 2);
        } 
        else {
            return x * fastPow(x * x, n / 2);
        }
    }
}
