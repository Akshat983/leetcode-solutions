class Solution {
    public int countPalindromicSubsequence(String s) {
        int l=s.length();
        char[] ar=new char[l];
        int a=0;
        int total=0;
        for(int i=0;i<l;i++)
        {
            int c=0;
            if(i>=1&&a>0&&s.charAt(i)==ar[a-1])
            continue;
            for (int j = 0; j < l; j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    if(j<i)
                        break ;
                    c++;
                    if(c==2)
                        break;
                }
            }
            if(c==2)
            {
                ar[a]=s.charAt(i);
                a++;
            }
        }
        for (int i = 0; i < a; i++) {
            int first=s.indexOf(ar[i]);
            int last=s.lastIndexOf(ar[i]);
            for (int j = first+1; j < last; j++) {
                int c=0;
                for (int k = first+1; k < j; k++) {
                    if(s.charAt(j)==s.charAt(k)){
                        c++;
                        break;
                    }
                }
                if(c==0)
                    total++;
            }
        }
        return total;
    }
}