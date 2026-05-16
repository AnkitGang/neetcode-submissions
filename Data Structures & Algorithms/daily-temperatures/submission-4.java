class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if(temperatures == null || temperatures.length == 0 || temperatures.length == 1)
            return result;

        for(int i=0; i<temperatures.length-1; i++) {
            int high = 0;
            for(int j=i+1; j<temperatures.length; j++) {
                if(temperatures[j] > temperatures[i]) {
                    high = j - i;
                    break;
                }
            }
            result[i] = high;
        }

        return result;
    }
}
