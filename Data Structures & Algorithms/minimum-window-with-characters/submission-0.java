class Solution {
    public String minWindow(String s, String t) {
        //Brute force
        if(t.length() > s.length())
            return "";

        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int start = -1;
        int minLen = Integer.MAX_VALUE;

        while(left < s.length()) {
            Map<Character, Integer> backup = new HashMap<>(freqMap);
            int bLen = t.length();
            int right = left;

            while(right < s.length() && bLen > 0) {            
                char rightChar = s.charAt(right);

                if(backup.containsKey(rightChar)) {
                    if(backup.get(rightChar) > 0) {
                        backup.put(rightChar, backup.get(rightChar) - 1);
                        bLen--;
                    }
                }

                if(bLen == 0) {
                    int windowSize = right - left + 1;
                    if(windowSize < minLen) {
                        minLen = windowSize;
                        start = left;
                    }
                    break;
                }

                right++;
            }

            left++;
        }

        if(start == -1)
            return "";
        
        return s.substring(start, start + minLen);
    }
}
