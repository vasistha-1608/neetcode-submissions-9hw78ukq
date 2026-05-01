class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int len = temperatures.length;
        Arrays.fill(result,0);
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(temperatures[j]>temperatures[i]){
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }
}
