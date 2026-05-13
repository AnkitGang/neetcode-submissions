class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int i=1;

        while(i < s.length()) {
            if(s.charAt(i) == '[' || s.charAt(i) == '{' ||s.charAt(i) == '(')
                stack.push(s.charAt(i));
            else{
                if(stack.isEmpty())
                    return false;
                if((s.charAt(i) == ']' && stack.peek() != '[') ||
                   (s.charAt(i) == '}' && stack.peek() != '{') ||
                   (s.charAt(i) == ')' && stack.peek() != '('))
                    return false;

                stack.pop();
            }
            i++;
        }

        if(stack.isEmpty())
            return true;
        
        return false;
    }
}
