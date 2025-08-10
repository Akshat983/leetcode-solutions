class Solution {
    public int removeDuplicates(int[] ar) {
        int curr = ar[0];
        int k = 1;
        for (int i = 1; i < ar.length; i++) {
            if((curr ^ ar[i]) != 0) {
                curr = ar[i];
                ar[k] = ar[i];
                k++;
            }
        }
        return k;
    }
}