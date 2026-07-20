class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans  = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) {
            List<Integer> r = new ArrayList<>();
            for(int j = 0; j < grid[0].length; j++) {
                r.add(0);
            }
            ans.add(r);
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                int r = i, c = j+k;
                    int add = c/grid[0].length;
                    c = c%grid[0].length;
                    r = r+add;
                    r = r%grid.length;
                
                ans.get(r).set(c, grid[i][j]);
            }
        }
        return ans;
    }
}