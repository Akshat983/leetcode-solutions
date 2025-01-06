class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l=arr.length;
        int start=0,end=l-1;
        while(start!=end)
        {
            int mid=(end+start)/2;
            if(arr[mid]>arr[mid+1])
                end=mid;
            else
                start=mid+1;
        }
        return(start);
    }
}