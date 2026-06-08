class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int count =0;
        int left =0;
        int right =0;
        int n = s.length();
        while(right<n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                count = Math.max(right-left+1,count);
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
            
        }
        return count;
    }
}
