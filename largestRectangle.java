import java.util.*;
public class largestRectangle {
    public static int largestRectangleArea1(int[] heights) {//BRUTE FORCE O(n^2)
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int minHeight = heights[i];
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int area = minHeight * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] height) {
        int n = height.length;

        //To calculate right smaller nearest
        Stack<Integer> s = new Stack<>();
        int right[] = new int[n];
        for(int i = n-1; i>=0; i--) {
            while (s.size()>0 && height[s.peek()] >= height[i]) {
                s.pop();
            }
            right[i] = s.isEmpty()? n : s.peek();
            s.push(i);
        }

        // while (!s.isEmpty()) {
        //     s.pop();
        // } //OR
        s.clear();  // better way to clear stack

        //To calculate left smaller nearest
        // Stack<Integer> st = new Stack<>();
        int left[] = new int[n];
        for(int i = 0; i<n; i++) {
            while (s.size()>0 && height[s.peek()] >= height[i]) {
                s.pop();
            }
            left[i] = s.isEmpty()? -1 : s.peek();
            s.push(i);
        }

        int ans = 0;
        for(int i = 0; i<n; i++) {
            int currArea = height[i] * (right[i]-left[i]-1);
            ans = Math.max(ans, currArea);
        }
        return ans;
    }
    public static void main(String[] args) {
        int height[] = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(height));
    }
}
