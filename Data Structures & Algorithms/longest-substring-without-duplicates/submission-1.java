class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Brute force 
        HashSet<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int len = 0;
        int ans = 0;

        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                if(set.contains(arr[j]))
                    break;

                set.add(arr[j]);
                ans = Math.max(ans, set.size());
            }
            set.clear();
        }

        return ans;
    }
}
