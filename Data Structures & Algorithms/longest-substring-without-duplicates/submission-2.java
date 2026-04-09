class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int count = 1;
        
        for(int i=0; i<s.length(); i++){
           Set<Character> seen = new HashSet<>();
           seen.add(s.charAt(i));
           int localCount = 1;
           for(int j=i+1; j<s.length(); j++){
               if(seen.contains(s.charAt(j))){
                   break;
               }
               seen.add(s.charAt(j));
               localCount++;
           }
           count = Math.max(count,localCount); 
        }

        return count;
    }
}
