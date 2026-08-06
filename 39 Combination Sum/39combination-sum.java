class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> curr, int[] candidates, int start, int target) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] > target) {
                break;
            }
            curr.add(candidates[i]);
            dfs(res, curr, candidates, i, target - candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}