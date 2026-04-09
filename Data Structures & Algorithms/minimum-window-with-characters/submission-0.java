class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        int[] map = new int[128]; 
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int count = t.length(); 

        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);

            if (map[rChar] > 0) {
                count--;
            }

            map[rChar]--;
            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                char lChar = s.charAt(left);
                
                map[lChar]++;

                if (map[lChar] > 0) {
                    count++;
                }

                left++; 
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}