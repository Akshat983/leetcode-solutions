class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> result = new ArrayList<>();
        String[][] pairs = new String[n][2];
        for (int i = 0; i < n; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            pairs[i][0] = new String(chars); 
            pairs[i][1] = strs[i];       
        }
        Arrays.sort(pairs, (a, b) -> a[0].compareTo(b[0]));
        List<String> group = new ArrayList<>();
        String prevKey = pairs[0][0];
        for (int i = 0; i < n; i++) {
            String key = pairs[i][0];
            String word = pairs[i][1];
            if (!key.equals(prevKey)) {
                result.add(group);
                group = new ArrayList<>();
                prevKey = key;
            }
            group.add(word);
        }
        result.add(group); 
        return result;
    }
}
