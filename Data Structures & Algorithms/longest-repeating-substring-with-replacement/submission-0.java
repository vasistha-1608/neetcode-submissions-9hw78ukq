class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // Frequency map for the current window
        int left = 0;
        int maxFreq = 0; // Most frequent char count inside the CURRENT window
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // 1. Add current char to the window count
            int index = s.charAt(right) - 'A';
            count[index]++;
            
            // 2. Update the max frequency found so far in this window
            maxFreq = Math.max(maxFreq, count[index]);

            // 3. Check if window is valid:
            // Window Size = (right - left + 1)
            // If (Window Size - MaxFreq) > k, we need too many replacements.
            while ((right - left + 1) - maxFreq > k) {
                // Shrink window from the left
                int leftIndex = s.charAt(left) - 'A';
                count[leftIndex]--;
                left++;
            }

            // 4. Update the global maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}