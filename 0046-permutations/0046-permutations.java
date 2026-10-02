class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length - 1;
        int i = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        backtrack(a, ans, nums);
        return ans;
    }
    private void backtrack(List<Integer> a, List<List<Integer>> ans, int[] nums) {
        if(a.size() == nums.length) {
            ans.add(new ArrayList(a));
            return;
        }
        for(int i : nums) {
            if(a.contains(i)) continue;
            a.add(i);
            backtrack(a, ans, nums);
            a.remove(a.size() - 1);
        }
    }
}