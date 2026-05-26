class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missing = arr[0] - 1;

        if (k <= missing) return k;

        for (int i = 1; i < arr.length; i++) {
            int gap = arr[i] - arr[i - 1] - 1;
            missing += gap;

            if (k <= missing) {
                return arr[i] - (missing - k) - 1;
            }
        }

        return arr[arr.length - 1] + (k - missing);
    }
}