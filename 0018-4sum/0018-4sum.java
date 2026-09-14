class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < n - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                long sum = (long) nums[i] + nums[j];
                int lp = j + 1;
                int rp = n - 1;

                while(lp < rp) {
                    long curr = sum + nums[lp] + nums[rp];

                    if(curr == target) {
                        ans.add(new ArrayList<>(List.of(nums[i], nums[j], nums[lp], nums[rp])));

                        while(lp < rp && nums[lp + 1] == nums[lp]) lp++;
                        while(lp < rp && nums[rp - 1] == nums[rp]) rp--;

                        lp++;
                        rp--;
                    }
                    else if(curr < target) {
                        lp++;
                    }
                    else {
                        rp--;
                    }
                }
            }
        }

        return ans;
    }
}