class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding Window
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        int ans = 0;

        while(right < s.length()) {
            //increment right only when window is unique, unil then
            //remove a character from left until duplicate is removed
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                ans = Math.max(ans, set.size());
                right++;
            }
            else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return ans;
    }
}
