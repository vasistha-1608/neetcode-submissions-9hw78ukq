class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort by ascending starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        
        // Grab the very first interval to start the process
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextBegin) {
                // They overlap! Update the end of the current interval sitting in the list.
                // We don't add a new one, we just mutate the existing one.
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap. This interval stands alone.
                // Add it to the list, and make IT the new "currentInterval" we check against.
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        // Convert the List<int[]> back to an int[][]
        return merged.toArray(new int[merged.size()][]);
    }
}
