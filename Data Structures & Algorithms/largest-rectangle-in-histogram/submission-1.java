

class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>(); // Stores indices
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {

            // Treat the bar after the last one as height 0
            int currHeight = (i == n) ? 0 : heights[i];

            // Process all bars taller than the current bar
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {

                // Height of the rectangle
                int height = heights[stack.pop()];

                // Previous smaller element's index
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();

                // Width between previous smaller and current smaller
                int width = i - leftBoundary - 1;

                // Compute area
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}