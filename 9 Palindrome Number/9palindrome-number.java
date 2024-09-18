class Solution {
    public boolean isPalindrome(int x) {
        String st=Integer.toString(x);
        int l=st.length();
        String nst="";
        for(int i=l-1;i>=0;i--)
        {
            nst=nst+st.charAt(i);
        }
        if(nst.equals(st))
        {
            return true;
        }
        else
        return false;
        
    }
}