class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];
            while (!stack.isEmpty() && currentTemp > temperatures[stack.peek()]) {
                int prevDayIndex = stack.pop();
                result[prevDayIndex] = i - prevDayIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
