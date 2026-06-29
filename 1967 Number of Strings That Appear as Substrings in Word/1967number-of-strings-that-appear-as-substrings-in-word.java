class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int n=0;
        for(String i: patterns ){
            if(word.contains(i)) n++;
        }
        return n;
    }
}