class Solution {
    public int countSubstrings(String s) {
       if(s==null || s.length()==0) return 0;
        int sum = 0;
        for(int index =0;index<s.length();index++){
            int left = index-1 ;
            int right = index +1;
            while(left>=0 && right <s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    left--;
                    right++;
                    sum ++;
                }
                else{
                    break;
                }
            }

            left = index;
            right = index+1;
            while(left>=0 && right <s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    left--;
                    right++;
                    sum ++;
                }
                else{
                    break;
                }
            }

            sum++;
        }
        return sum;
    }
}
