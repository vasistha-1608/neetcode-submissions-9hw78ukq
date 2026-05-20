class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String subString = strs[0]; 
        
        for (int i = 1; i < strs.length; i++) {
            String curr = strs[i];
            int count = 0;
            
            
            while (count < subString.length() && count < curr.length()) {
                if (subString.charAt(count) == curr.charAt(count)) {
                    count++;
                } else {
                    break; 
                }
            }
            
            
            subString = subString.substring(0, count);
            if (subString.isEmpty()) {
                return "";
            }
        }
        
        return subString;
    }
}