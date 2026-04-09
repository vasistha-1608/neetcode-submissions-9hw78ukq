class Solution {
    public boolean isPalindrome(String s) {
      s = s.replaceAll("\\s+","");
      s = s.replaceAll("[^a-zA-Z0-9]", "");
      String temp = s.toLowerCase();
      
       String end = "";
       for(int i=temp.length()-1;i>=0;i--){
        end = end + temp.charAt(i);
       }
       
    return temp.equals(end);

    }
}
