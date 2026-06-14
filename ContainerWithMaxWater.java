class Solution {

    public int maxArea(int[] height) {

        int n = height.length;

        // Left pointer at beginning
        int left = 0;

        // Right pointer at end
        int right = n - 1;

        // Stores maximum area found so far
        int maxArea = 0;

        while (left < right) {

            // Container height is limited by smaller wall
            int h = Math.min(height[left], height[right]);

            // Distance between walls
            int w = right - left;

            // Current container area
            int area = h * w;

            // Update maximum area
            maxArea = Math.max(maxArea, area);

            /*
             Move pointer having smaller height.

             Why?

             Current area is limited by smaller wall.

             To get larger area:
             We need a potentially taller wall.

             Moving taller wall is useless because:
             Width decreases and limiting height remains same.
            */

            if (height[left] < height[right]) {

                left++;

            } else {

                right--;
            }
        }

        // Return largest area found
        return maxArea;
    }
}
/*
Problem: Container With Most Water

Pattern: Two Pointers

Idea:
- Use two pointers:
    left  -> start of array
    right -> end of array

- Water stored depends on:
    Area = Height × Width

- Height is determined by the smaller line:
    min(height[left], height[right])

- Width is:
    right - left

- Calculate area for every valid container.

Optimization:
- Move the pointer having smaller height.
- Because area is limited by the shorter line.
- Keeping the shorter line and reducing width can never increase area.

Time Complexity: O(n)

Reason:
Each pointer moves at most n times.

Space Complexity: O(1)

Reason:
Only constant extra variables used*/
