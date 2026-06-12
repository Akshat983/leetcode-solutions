class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = 0, b = 0;
        int total = m;

        while (a < total && b < n) {
            if (nums1[a] <= nums2[b]) {
                a++;
            } else {
                shiftRight(nums1, total, a);
                nums1[a] = nums2[b];
                a++;
                b++;
                total++; 
            }
        }
        while (b < n) {
            nums1[total++] = nums2[b++];
        }
    }

    void shiftRight(int[] arr, int length, int idx) {
        for (int i = length - 1; i >= idx; i--) {
            arr[i + 1] = arr[i];
        }
    }
}
