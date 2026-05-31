class Solution {
    public int findDuplicate(int[] nums) {
        int[] freq = new int[10000];

        for(int i=0; i<nums.length; i++) {
            if(freq[nums[i]] != 0)
                return nums[i];
            
            freq[nums[i]]++;
        }

        return 0;
    }
}
