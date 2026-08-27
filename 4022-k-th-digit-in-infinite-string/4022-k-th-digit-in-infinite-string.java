class Solution {
    public int kthDigit(long k) {
        if( k <= 9) return (int)k;
        k -= 9;
        long d = 2;
        long countBlocks = 9;
        while(k > countBlocks * 10 * d) {
            k -= countBlocks * 10 * d;
            countBlocks *= 10;
            d++;
        }

        long digitsPerBlock = 10*d;
        long blockIdx = (k-1) / digitsPerBlock;
        long remK = (k-1) % digitsPerBlock;

        long startB = 1;
        for(int i = 0; i < d-2; i++) {
            startB *= 10;
        }
        long b = startB + blockIdx;

        long numIdx = remK/d;
        long digitIdx = remK % d;

        long actualNum;
        if(b % 2 == 0) {
            actualNum = 10*b + numIdx;
        }
        else {
            actualNum = 10*b + 9 - numIdx;
        }
        String s = String.valueOf(actualNum);
        return s.charAt((int) digitIdx) - '0';
    }
}