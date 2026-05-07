class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);
            if(map.containsKey(key))
                map.get(key).add(str);
            else {
                ArrayList<String> l = new ArrayList<>();
                l.add(str);
                map.put(key, l);
            }
        }
        for(String key : map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }
}
