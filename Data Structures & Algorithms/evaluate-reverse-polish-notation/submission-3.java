class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();

        for(String s : tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int b = operands.pop();
                int a = operands.pop();

                switch(s) {
                    case "+":
                        operands.push(a + b);
                        break;
                    case "-":
                        operands.push(a - b);
                        break;
                    case "*":
                        operands.push(a * b);
                        break;
                    case "/":
                        operands.push(a / b);
                        break;
                }
            }
            else 
                operands.push(Integer.parseInt(s));
        }
        return operands.pop();
    }
}
