class Solution {
  public int shipWithinDays(int[] weights, int days) {
     int max =0;
     int low =0;
     for(int i=0;i<weights.length;i++){
        low = Math.max(weights[i],low);
        max = max + weights[i];
     }
    
    

    int answer =0;

    while(max>=low){
        int mid = low + (max - low) / 2;
        if (canBeshipped(weights, days, mid)) {
                
                answer = mid;
                
                max = mid - 1; 
            } else {
                
                low = mid + 1;
            }
    }
    return answer;
    }

    public boolean canBeshipped(int[] weights, int days, int capacity ){
        int daysNeeded = 1; 
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                daysNeeded++;
                currentLoad = weight; 
                
                if (daysNeeded > days) {
                    return false;
                }
            } else {
                currentLoad += weight;
            }
        }
        
        return true;        

    }
}