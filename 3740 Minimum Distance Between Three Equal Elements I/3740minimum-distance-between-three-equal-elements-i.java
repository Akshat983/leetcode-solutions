class Solution {
    public int minimumDistance(int[] nums) {
        int[] hash = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            hash[nums[i]-1]++;
        }
        Boolean in = false;
        int min = Integer.MAX_VALUE;;
        for(int i = 0; i < nums.length; i++) {
            if(hash[i] >= 3) {
                min = Math.min(min, calculate(nums, i+1));
                in = true;
            }
        }
        if(!in) return -1;
        return min;
    }
    public int calculate(int[] nums, int num) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == num) {
                l.add(i);
            }
        }
        int minidx = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < l.size()-2; i++) {
            int cal = l.get(i+2) - l.get(i);
            if(cal < min) {
                minidx = l.get(i);
                min = cal;
            }
        }
        return 2*min;
    }
}