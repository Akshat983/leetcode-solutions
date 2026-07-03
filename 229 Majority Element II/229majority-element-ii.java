class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n1 = 0, n2 = 0;
        int c1 = 0, c2 = 0;
        for(int i : nums) {
            if(i == n1) c1++;
            else if(i == n2) c2++;
            else if(c1 == 0) {
                c1 = 1;
                n1 = i;
            }
            else if(c2 == 0) {
                c2 = 1;
                n2 = i;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int i : nums){
            if(i == n1) c1++;
            if(i == n2) c2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(c1 > nums.length/3) ans.add(n1);
        if(c2 > nums.length/3 & n1 != n2) ans.add(n2);
        return ans;
    }
}