class Solution {
    public boolean checkStrings(String s1, String s2) {
        char[] evens1 = new char[s1.length()];
        char[] odds1 = new char[s1.length()];
        char[] evens2 = new char[s1.length()];
        char[] odds2 = new char[s1.length()];
        calc(evens1, odds1, s1);
        calc(evens2, odds2, s2);
        return (Arrays.equals(evens1, evens2) && Arrays.equals(odds1, odds2));
            
    }
    void calc(char[] evens, char[] odds, String s) {
        int j = 0, k = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i%2 == 0) {
                evens[j++] = s.charAt(i);
            }
            else {
                odds[k++] = s.charAt(i);
            }
        }
        Arrays.sort(evens);
        Arrays.sort(odds);
    }
}