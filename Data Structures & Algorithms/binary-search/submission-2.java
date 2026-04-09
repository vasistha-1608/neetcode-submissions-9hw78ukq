class Solution {
    public int search(int[] nums, int target) {
        int high= nums.length;
        int low =0;
        while(low<high){
            int mid = (high+low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high= mid;
            }
        }

        return-1;
        
    }
}
