class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=nums.length,count=0,index=0;
        if(nums[0]>target)
        index=0;
        if(nums[l-1]<target)
        index=l;
        for(int i=0;i<l;i++)
        {
            if(target==nums[i])
            {
            index=i;
            count++;
            }
        }
        for(int i=0;i<l-1;i++)
        {
            if(count==0)
            {
                if(nums[i]<target&&nums[i+1]>target)
                index=i+1;
            }
        }
        return index;

    }
}