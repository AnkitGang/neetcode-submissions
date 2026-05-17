class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<position.length; i++) 
            map.put(position[i], i);
        
        Arrays.sort(position);
        for(int i=0; i<position.length / 2; i++) {
            int temp = position[i];
            position[i] = position[position.length - i - 1];
            position[position.length - i - 1] = temp;
        }
        
        int[] new_speed = new int[speed.length];
        for(int i=0; i<position.length; i++) {
            new_speed[i] = speed[map.get(position[i])];
        }
        
        Stack<Double> timeStack = new Stack<>();

        for(int i=0; i<position.length; i++) {
            double timeToReach = (double)(target - position[i]) / new_speed[i];
            if(timeStack.isEmpty() || timeToReach > timeStack.peek())
                timeStack.push(timeToReach);
        }

        return timeStack.size();
    }
}
