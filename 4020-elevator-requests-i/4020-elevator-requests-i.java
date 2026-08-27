class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int ans = 0;
        int j = 0;
        for(int i : requests) {
            ans = ans + (Math.abs(i - j));
            j = i;
        }
        return ans;
    }
}