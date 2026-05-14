class Solution {
    public int evalRPN(String[] tokens) {
        int value = 0;
        if(tokens == null || tokens.length == 0)
            return value;
        else if(tokens.length == 1)
            return Integer.parseInt(tokens[0]); //assuming tokens are valid

        Stack<Integer> operands = new Stack<>();

        for(String s : tokens) {
            try {
                int number = Integer.parseInt(s);
                operands.push(number);
            }
            catch(NumberFormatException e) {
                List<Integer> exp = new ArrayList<>();
                for(int i=0; i<2; i++) {
                    exp.add(operands.pop());
                }
                if(s.equals("+")) {
                    value = exp.get(1) + exp.get(0);
                    operands.push(value);
                }
                else if(s.equals("-")) {
                    value = exp.get(1) - exp.get(0);
                    operands.push(value);
                }
                else if(s.equals("*")) {
                    value = exp.get(1) * exp.get(0);
                    operands.push(value);
                }
                else if(s.equals("/")) {
                    value = exp.get(1) / exp.get(0);
                    operands.push(value);
                }
            }
        }
        return value;
    }
}
