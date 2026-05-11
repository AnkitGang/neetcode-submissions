class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]", "").trim().toLowerCase();

        StringBuilder sb = new StringBuilder(str);
        if(str.equalsIgnoreCase(sb.reverse().toString()))
            return true;

        return false;
    }
}
