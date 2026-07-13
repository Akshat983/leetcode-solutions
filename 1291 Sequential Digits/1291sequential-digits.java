class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int ll = (int)Math.log10(low) +1;
        int hl = (int)Math.log10(high) +1;
        String st = "123456789";
        List<Integer> ans = new ArrayList<>();
        for(int l = ll; l <= hl; l++) {
            for(int i = 0; i < 10-l; i++) {
                int num = Integer.parseInt(st.substring(i, i+l));
                if(num <= high && num >= low) {
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}