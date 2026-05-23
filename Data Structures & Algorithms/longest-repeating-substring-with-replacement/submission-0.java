class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int ans = 0;
        int maxFrequency = 0;
        int maxWindowSize = 0;

        while(right < s.length()) {
            char rightChar = s.charAt(right);
            freq[rightChar - 'A']++;

            maxFrequency = Math.max(maxFrequency, freq[rightChar - 'A']);

            while((right - left + 1) - maxFrequency > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }      

            maxWindowSize = Math.max(maxWindowSize, (right - left + 1));
            right++;
        }

        return maxWindowSize;
    }
}
