class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long currM = mass;
        Arrays.sort(asteroids);
        for(int i = 0; i < asteroids.length; i++) {
            if(asteroids[i] <= currM) {
                currM+=asteroids[i];
            }
            else {
                return false;
            }
        }
        return true;
    }
}