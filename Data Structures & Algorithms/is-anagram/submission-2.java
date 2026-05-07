class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for (char c : s.toCharArray())
            smap.put(c, smap.getOrDefault(c, 0) + 1);
        
        for (char c : t.toCharArray())
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);

        if (smap.size() != tmap.size())
            return false;

        for (Character c : smap.keySet()){
            if (!tmap.containsKey(c))
                return false;
            
            if (!smap.get(c).equals(tmap.get(c)))
                return false;
        }

        return true;
    }
}
