class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        
        int leftMax = height[left];
        int rightMax = height[right];
        
        int totalWater = 0;

        // Move the pointers inward until they meet
        while (left < right) {
            
            // The left side is the bottleneck
            if (leftMax < rightMax) {
                left++; // Move pointer inward
                leftMax = Math.max(leftMax, height[left]); // Update the highest wall seen so far
                totalWater += leftMax - height[left];      // Add the trapped water
            } 
            // The right side is the bottleneck
            else {
                right--; // Move pointer inward
                rightMax = Math.max(rightMax, height[right]); // Update the highest wall seen so far
                totalWater += rightMax - height[right];       // Add the trapped water
            }
        }

        return totalWater;
    }
}