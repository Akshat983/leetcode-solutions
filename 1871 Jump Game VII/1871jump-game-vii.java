class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int l = s.length();
        boolean[] dp = new boolean[l];
        dp[0] = true;
        int far = 0;
        for(int i = 0; i < l; i++) {
            if(!dp[i]) continue;
            int st = Math.max(far+1, i+minJump);
            int end = Math.min(l-1, i+maxJump);
            for(int j = st; j <= end; j++) {
                if(s.charAt(j) - '0' == 0) {
                    dp[j] =  true;
                }
            }
            far = end;
        }
        return dp[l-1];
    }
}
