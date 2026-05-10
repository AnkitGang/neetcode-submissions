class Solution {
    char key = '-';

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String str : strs) {
            encodedString.append(str.length())
                         .append(key)
                         .append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedString = new ArrayList<>();
        if(str.length() == 0)
            return decodedString;
        int i=0; 
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != key) {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            j++;
            decodedString.add(str.substring(j, j + length));
            i = j+length;
        }
        return decodedString;
    }
}
