class Solution {
   public int minEatingSpeed(int[] piles, int h) {
       int max =0;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
       
       int left = 1, right =max;
       while(left<right){
        int mid = (int)Math.floor((left+right)/2);
        
         if(isPossible(piles,mid,h)){
            right = mid;
         }
            else{
                left = mid+1;
            }

       }
    return right;
   }

   public boolean isPossible(int[] piles, int mid, int h){
      
      long sum =0;
      for(int i=0;i<piles.length;i++){
        sum += (piles[i]+ mid -1)/mid;
       
      }
   
    return sum<=h ? true : false;

   }
}
