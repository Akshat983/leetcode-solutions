class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(min > nums[i]) min = nums[i];
            if(max < nums[i]) max = nums[i];
        }
        return gcd(min, max);
    }
    int gcd(int n1, int n2) {
        while(n1!=n2) {
            if(n1>n2) {
                n1-=n2;
            }
            else n2-=n1;
        }
        return n1;
    }
}