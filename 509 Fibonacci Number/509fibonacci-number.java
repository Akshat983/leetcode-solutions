class Solution {
    public int fib(int n) {
        int[] ar = new int[n+1];
        Arrays.fill(ar, -1);
        return fibHelper(ar, n);
    }
    public int fibHelper(int[] ar, int n) {
        if(n==0||n==1){return n;}
        if(ar[n]!=-1){return ar[n];}
        int a = fibHelper(ar, n-1);
        int b = fibHelper(ar, n-2);
        ar[n] = a+b;
        return a+b;
    }
}