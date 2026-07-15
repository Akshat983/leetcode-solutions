class Solution {
    public int gcdOfOddEvenSums(int n) {
        int n1 = n*n;
        int n2 = n*(n+1);
        while(n1 != n2) {
            if(n1>n2) n1-=n2;
            else n2-=n1;
        }
        return n1;
    }
}