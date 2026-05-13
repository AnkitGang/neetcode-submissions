class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int rainWaterCollected = 0;
        int leftMax=0;
        int rightMax=height.length-1;
        
        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] > height[leftMax])
                    leftMax = left;
                else
                    rainWaterCollected += height[leftMax] - height[left];
                
                left++;
            }
            else {
                if(height[right] > height[rightMax])
                    rightMax = right;
                else
                    rainWaterCollected += height[rightMax] - height[right];

                right--;
            }
        }
        return rainWaterCollected;
    }
}
