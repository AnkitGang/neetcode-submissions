class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] arr = map.entrySet().stream()
                                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                                .map(Map.Entry :: getKey)
                                .mapToInt(Integer :: intValue)
                                .toArray();
        
        return Arrays.copyOfRange(arr, 0, k);
    }
}
