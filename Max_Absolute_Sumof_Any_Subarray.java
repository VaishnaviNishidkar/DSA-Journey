class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int maxEndingHere = 0;
        int minEndingHere = 0;

        int maxSum = 0;
        int minSum = 0;

        for (int num : nums) {

            // Maximum Subarray (Kadane)
            maxEndingHere += num;
            maxSum = Math.max(maxSum, maxEndingHere);

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }

            // Minimum Subarray (Reverse Kadane)
            minEndingHere += num;
            minSum = Math.min(minSum, minEndingHere);

            if (minEndingHere > 0) {
                minEndingHere = 0;
            }
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
  
}
/*Problem:
Maximum Absolute Sum of Any Subarray (LC 1749)

Pattern:
Kadane's Algorithm

Idea:

• Find Maximum Subarray Sum.
• Find Minimum Subarray Sum.
• Answer = max(maxSum, |minSum|).

Algorithm:

1. Track maxEndingHere.
2. Track minEndingHere.
3. Update maxSum and minSum.
4. Reset:
      maxEndingHere < 0 → 0
      minEndingHere > 0 → 0
5. Return max(maxSum, abs(minSum)).

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Observation:

Maximum Absolute Sum =
Maximum Positive Sum
OR
Absolute of Minimum Negative Sum.
----Memory trick----
  Normal Kadane
        ↓
Find Maximum Sum

Reverse Kadane
        ↓
Find Minimum Sum

Answer
        ↓
max(maxSum, |minSum|)*/
