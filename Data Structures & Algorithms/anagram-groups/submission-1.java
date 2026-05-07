class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
            return List.of();
        
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] freq = new int[26];
            for(char c : str.toCharArray())
                freq[c - 'a']++;
            
            String seq = Arrays.toString(freq);
            map.putIfAbsent(seq, new ArrayList());
            map.get(seq).add(str);
        }
        return new ArrayList(map.values());
    }
}
