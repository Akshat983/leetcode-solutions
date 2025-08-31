class Solution {
    public int divsum(int[] nums, int div) {
        int sum=0;
        for(int i = 0; i < nums.length; i++) {
            sum += (int)(Math.ceil((double)nums[i]/div));
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max  = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(max < nums[i])
                max = nums[i];
        }
        int s = 1, e = max;
        int mid= (s+e)/2;
        while(s<=e){
            mid = (s+e)/2;
            if(divsum(nums, mid) > threshold){
                s = mid+1;
            }
            else{
                e= mid;
            }
            if(s==e){
                return s;
            }
        }
        return mid;
    }
}