class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start=0,end=numbers.length-1,mid;
        while(start<end)
        {
            mid=start+(end-start)/2;
            if(numbers[start]+numbers[end]>target)
            {
                if(numbers[start]+numbers[mid]>target)
                    end=mid-1;
                else if(numbers[start]+numbers[mid]<target)
                    end--;
                else return new int[] {start+1,mid+1};
            }
            else if (numbers[start]+numbers[end]<target) {
                if(numbers[mid]+numbers[end]<target)
                    start=mid+1;
                else if(numbers[mid]+numbers[end]>target)
                    start++;
                else return new int[]{mid+1,end+1};
            }
            else return new int[] {start+1,end+1};
    }
    return new int[]{-1,-1};
    }}