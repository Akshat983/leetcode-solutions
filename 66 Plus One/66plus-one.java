class Solution {
    public int[] plusOne(int[] digits) {
        int l=digits.length-1;
        if(digits[l]!=9)
        {
            digits[l]=digits[l]+1;
            return(digits);
        }
        for(int i=l;i>=0;i--)
        {
            if(digits[i]!=9) {
                digits[i]=digits[i]+1;
                return digits;
            }digits[i]=0;
        }
        int[] ans=new int[l+2];
        for(int i=0;i<l+2;i++)
        {
            if(i==0)
            ans[i]=1;
            else
            ans[i]=0;
        }
        return ans;
    }
}