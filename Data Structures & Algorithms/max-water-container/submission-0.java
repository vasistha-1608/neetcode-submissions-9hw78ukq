class Solution {
    public int maxArea(int[] heights) {
        int area = Integer.MIN_VALUE;
        for(int i=0;i<heights.length-1;i++){
            int left = i+1;
            while(left<= heights.length-1){
                int localArea = Math.min(heights[i],heights[left]) * (left-i);
                area = Math.max(localArea,area);
                left++;
            }
          
        }
        return area;
    }
}
