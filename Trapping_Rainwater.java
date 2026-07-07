class Solution {
    public int trap(int[] height) {

        int n = height.length;
        if (n == 0) return 0;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = height[0];
        right[n - 1] = height[n - 1];

        // Left maximum
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        // Right maximum
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        int totalWater = 0;

        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(left[i], right[i]) - height[i];
        }

        return totalWater;
    }
}
/*```text
Problem:
Trapping Rain Water (LC 42)

Pattern:
Prefix Max Arrays

Idea:

• Water at each index depends on:
      Left Maximum Height
      Right Maximum Height

• Water stored at index i:
      min(leftMax[i], rightMax[i]) - height[i]

Algorithm:

1. Build leftMax array.
      left[i] = max(height[i], left[i-1])

2. Build rightMax array.
      right[i] = max(height[i], right[i+1])

3. For every index:
      water = min(left[i], right[i]) - height[i]
      Add water to total.

4. Return total trapped water.

Time Complexity:
O(n)

Reason:
Three linear traversals of the array.

Space Complexity:
O(n)

Reason:
Two extra arrays (leftMax and rightMax).

Key Observation:

• Water is trapped only if there are taller bars on both sides.
• Water at an index is limited by the smaller of the two maximum heights.
• Formula:
      Water = min(leftMax, rightMax) - currentHeight
```
*/
