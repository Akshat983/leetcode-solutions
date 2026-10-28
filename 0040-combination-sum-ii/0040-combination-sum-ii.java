class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();

        helper(candidates, target, ans, 0, new ArrayList<>());
        return ans;
    }

    public void helper(int[] nums, int target, List<List<Integer>> ans,
                       int start, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target) break;

            temp.add(nums[i]);
            helper(nums, target - nums[i], ans, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}