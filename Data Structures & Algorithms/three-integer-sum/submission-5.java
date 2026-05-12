class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<3)
            return res;
        int target = 0;
        Arrays.sort(nums);

        for(int i=0; i<nums.length-1; i++) {
            if((nums.length - i - 1) < 2)
                break;

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == target) {
                    List<Integer> list = List.of(nums[i], nums[left], nums[right]);
                    res.add(list);
                    left++;
                }
                else if(sum < target)
                    left++;
                else
                    right--;
            }
        }

        List<List<Integer>> distinctList = new ArrayList<>(new LinkedHashSet<>(res));
        return distinctList;
    }
}
