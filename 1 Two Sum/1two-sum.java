class Solution {
    public int[] twoSum(int[] nums, int target)
    {
        int l=nums.length;int i,j=0;
        int ts[]=new int[2];
        for( i=0;i<l;i++)
        {
            for( j=i+1;j<l;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                ts[0]=i;
                ts[1]=j;
                return ts;
                }

            }

        }
        int ar[]={-1,-1};
        return ar;
    }
}