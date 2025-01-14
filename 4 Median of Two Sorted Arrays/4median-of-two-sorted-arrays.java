class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;
        int l=l1+l2;
        int arr[]=new int[l];
        for(int i=0;i<l;i++)
        {
            if(i<l1)
            {
                arr[i]=nums1[i];
            }
            else
            {
                arr[i]=nums2[i-l1];
            }
        }
        for(int j = 1; j < arr.length; j++)
        {
            for(int k = j; k > 0; k--)
            {
                if(arr[k] < arr[k-1])
                {
                    int rep=arr[k];
                    arr[k]=arr[k-1];
                    arr[k-1]=rep;
                }
                else  {
                    break;
                }
            }
        }
        if(l%2!=0)
        {
            int z=l/2;
            return arr[z];
        }
        else
        {
            int z=l/2;
            return (double)(arr[z-1]+arr[z])/2;
        }
        
    }
}