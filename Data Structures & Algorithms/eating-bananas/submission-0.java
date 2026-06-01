class Solution {
   public int minEatingSpeed(int[] piles, int h) {
        
        int maxPile = 1;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        
        int left = 1;
        int right = maxPile;
        int bestSpeed = right; 

        while (left <= right) {
            int mid = left + (right - left) / 2; 
            
            
            if (canFinish(piles, h, mid)) {
                bestSpeed = mid;   
                right = mid - 1;   
            } else {
                left = mid + 1;    
            }
        }

        return bestSpeed;
    }

    
    private boolean canFinish(int[] piles, int h, int k) {
        long hoursNeeded = 0; 
        
        for (int pile : piles) {
            hoursNeeded += (pile + k - 1) / k; 
        }
        
        return hoursNeeded <= h;
    }
}
