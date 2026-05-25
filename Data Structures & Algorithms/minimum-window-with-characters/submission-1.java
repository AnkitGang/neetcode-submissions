class Solution {
    public String minWindow(String s, String t) {
        // Sliding Window
        if(t.length() > s.length())
            return "";

        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int start = -1;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> windowMap = new HashMap<>();
        int requiredUniqueChar = freqMap.size();
        int count = 0;  // to count unique char count in window

        while(right < s.length()) {
            char rightChar = s.charAt(right);
            
            if(freqMap.containsKey(rightChar)) {
                windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);
                
                if(windowMap.get(rightChar).equals(freqMap.get(rightChar))) {
                    count++;
                }
            }

            while(count == requiredUniqueChar) {
                int windowSize = right - left + 1;

                if(windowSize < minLength) {
                    minLength = windowSize;
                    start = left;
                }
                
                char leftChar = s.charAt(left);

                if(freqMap.containsKey(leftChar)) {
                    // Critical element
                    if(windowMap.get(leftChar).equals(freqMap.get(leftChar))) {
                        count--; // so that it comes out of inner while loop
                    }
                    // because left will be incremented
                    // so current leftchar will no longer be in window
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }

                left++;
            }

            right++;
        }
        
        return start == -1 ? "" : s.substring(start, start + minLength);
    }
}
