class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;

        int[] s1Counts = new int[26];
        int[] windowCounts = new int[26];

        // Populate 1st window
        for(int i=0; i<s1.length(); i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            windowCounts[s2.charAt(i) - 'a']++;
        }

        //Check after window
        for(int i=s1.length(); i<s2.length(); i++) {
            if(matches(s1Counts, windowCounts)) {
                return true;
            }

            char leftChar = s2.charAt(i - s1.length());
            char rightChar = s2.charAt(i);
            
            //Add new char
            windowCounts[rightChar - 'a']++;
            //Remove 1st element of window to shift right
            windowCounts[leftChar - 'a']--;
        }
        
        //Last window last element added
        return matches(s1Counts, windowCounts);
    }

    private boolean matches(int[] s1Array, int[] windowArray) {
        for(int i=0; i<26; i++) 
            if(s1Array[i] != windowArray[i])
                return false;

        return true;
    }
}
