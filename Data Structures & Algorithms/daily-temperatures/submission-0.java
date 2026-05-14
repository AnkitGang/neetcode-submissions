class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if(temperatures == null || temperatures.length == 0 || temperatures.length == 1)
            return result;

        for(int i=0; i<temperatures.length-1; i++) {
            Stack<Integer> stack = new Stack<>();
            boolean found = false;
            for(int j=i+1; j<temperatures.length; j++) {
                if(temperatures[j] > temperatures[i]) {
                    stack.push(temperatures[j]);
                    result[i] = stack.size();
                    found = true;
                    break;
                }
                else 
                    stack.push(temperatures[j]);
            }
            if(!found)
                result[i] = 0;
        }

        return result;
    }
}
