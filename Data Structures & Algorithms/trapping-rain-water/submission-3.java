class Solution {
    public int trap(int[] height) {
        int area = 0;
        
        
        for(int i = 0; i < height.length; i++) {
            
            
            int leftMax = 0;
            for(int left = i; left >= 0; left--) {
                leftMax = Math.max(leftMax, height[left]);
            }
            
            
            int rightMax = 0;
            for(int right = i; right < height.length; right++) {
                rightMax = Math.max(rightMax, height[right]);
            }
            
            
            int curr = Math.min(leftMax, rightMax);
            
            area = area + (curr - height[i]);
        }

        return area;
    }
}