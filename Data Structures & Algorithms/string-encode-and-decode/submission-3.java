class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";
        for(String str : strs) {
            encodedString += "~" + str;
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> decodedString = new ArrayList<>();
        if(str.length() == 0)
            return decodedString;
        String[] arr = str.substring(1).split("~", -1);
        for(String s : arr) {
            decodedString.add(s);
        }
        return decodedString;
    }
}
