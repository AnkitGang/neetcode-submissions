class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1, 2, 4, 6]
        // [1, 2, 8, 48] - prefix mul
        // [48, 48, 24, 6] - suffix mul
        // [48, 24, 12, 8]
        
        int n = nums.length;
        if(n == 0 || n == 1)
            return nums;

        int[] prefixMulArr = new int[n];
        int[] suffixMulArr = new int[n];

        prefixMulArr[0] = nums[0];
        for(int i=1; i<n; i++) {
            prefixMulArr[i] = nums[i] * prefixMulArr[i-1];
        }

        suffixMulArr[n-1] = nums[n-1];
        for(int i=n-2; i>-1; i--) {
            suffixMulArr[i] = nums[i] * suffixMulArr[i+1];
        }
        
        int[] output = new int[n];
        for(int i=0; i<n; i++) {
            if(i == 0) {
                output[i] = suffixMulArr[i+1];
                continue;
            }

            if(i == n-1) {
                output[i] = prefixMulArr[i-1];
                continue;
            }

            output[i] = prefixMulArr[i-1] * suffixMulArr[i+1];
        }
        return output;
    }
}  
