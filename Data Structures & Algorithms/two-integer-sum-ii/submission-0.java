class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        int left =0;
        int right = numbers.length -1;
        while(left<right){
            int sum = numbers[left]+numbers[right]; 
            if(sum==target){
                index[0] = left+1;
                index[1]= right+1;
                return index;
            }
            else if(sum>target) {
                right--;
            }
            else{
                left ++;
            }
        }

        return index;
    }
}
