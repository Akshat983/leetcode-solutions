class Solution {
    public int[] searchRange(int[] ar, int t) {
        int l= ar.length;
        int[] ans=new int[2];
        // for first index
        int st=0,end=l-1,mid;
        while(st<=end)
        {
            mid=(st+end)/2;
            if(ar[mid]>=t)
                end=mid-1;
            else st=mid+1;
        }
        if(st<l&&ar[st]==t)
            ans[0]=st;
        else
            ans[0]=(-1);

        // for end index
        st=0;end=l-1;
        while(st<=end)
        {
            mid=(st+end)/2;
            if(ar[mid]>t)
                end=mid-1;
            else st=mid+1;
        }
        if(end>=0&&ar[end]==t)
            ans[1]=(end);
        else
            ans[1]=(-1);
            return(ans);
    }

}