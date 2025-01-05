class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int st=0,end=letters.length-1;
        while(st<=end)
        {
            int mid=end+(st-end)/2;
            if(target < letters[mid])
            end=mid-1;
            else
            st=mid+1;
        }
        return(letters[st%letters.length]);
    }
}