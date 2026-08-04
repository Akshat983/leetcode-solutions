class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        int j = 0;
        for(int i = nums[0]; i <= nums[nums.length-1]; i++) {
            if(nums[j] == i) {
                j++;
                continue;
            }
            l.add(i);
        }
        return l;
    }
}