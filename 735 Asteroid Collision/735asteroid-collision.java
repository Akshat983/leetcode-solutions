class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int l = asteroids.length;
        int[] st = new int[l];
        int top = -1;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < l; i++){
            if(asteroids[i] > 0) st[++top] = asteroids[i];
            else {
                if(top == -1) ans.add(asteroids[i]);
                else if(Math.abs(asteroids[i]) == st[top]) top--;
                else{
                    if(Math.abs(asteroids[i]) > st[top]){ top--; i--;}
                }
            }
        }
        for(int i = 0; i <= top; i++) ans.add(st[i]);
        int[] ab = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            ab[i] = ans.get(i);
        }
        return ab;
    }
}