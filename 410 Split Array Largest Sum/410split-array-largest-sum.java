class Solution {
    public int splitArray(int[] nums, int k) {
        int max = nums[0], sum = 0;
        for (int i : nums) {
            sum += i;
            if( max < i )
                max = i;
        }
        int start = max, end = sum;
        while (start < end)
        {
            int mid=start+(end-start)/2;
            sum=0;
            int peices=1;
            for(int num : nums)
            {
                if(sum+num>mid)
                {
                    sum=num;
                    peices++;
                    if(peices>k)
                    break;
                }
                else {
                    sum+=num;
                }
            }
            if(peices>k)
                start=mid+1;
            else end=mid;
        }
        return end;
    }
}