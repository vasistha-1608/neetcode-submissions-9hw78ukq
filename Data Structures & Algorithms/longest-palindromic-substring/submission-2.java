class Solution {
    public String longestPalindrome(String s) {
      if (s == null || s.length() == 0) return "";
      String result = s.substring(0,1);
     
      for(int index =0;index<s.length();index++){
        int left= index-1;
        int right = index +1;
        char ch = s.charAt(index);
        String temp = "";
        while(left>=0 && right<s.length()){
            if(s.charAt(left)==s.charAt(right)){
                temp = s.substring(left, right+1);
                left--;
                right++;
                
            }
            else {
                break;
            }

            if(temp.length()>result.length()){
                result = temp;
            }
        }

        left = index;
        right = index+1;
        temp = "";
            
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    temp = s.substring(left, right + 1);
                    left--;
                    right++;
                }
                else {
                    break;
                }

                if(temp.length() > result.length()){
                    result = temp;
                }
            }
      }
      return result;
    }
}
