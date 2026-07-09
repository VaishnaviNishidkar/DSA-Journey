class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Number of rows
        int m = matrix.length;

        // Number of columns
        int n = matrix[0].length;

        // Binary Search on rows
        int top = 0;
        int bottom = m - 1;

        // Stores the row where target may exist
        int row = -1;

        // Find the correct row
        while (top <= bottom) {

            // Middle row
            int mid = top + (bottom - top) / 2;

            // Target lies in this row
            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
                row = mid;
                break;
            }

            // Target is smaller than first element
            else if (target < matrix[mid][0]) {
                bottom = mid - 1;
            }

            // Target is greater than last element
            else {
                top = mid + 1;
            }
        }

        // Target cannot exist in any row
        if (row == -1)
            return false;

        // Binary Search within the selected row
        int left = 0;
        int right = n - 1;

        while (left <= right) {

            // Middle column
            int mid = left + (right - left) / 2;

            // Target found
            if (matrix[row][mid] == target) {
                return true;
            }

            // Search in the right half
            else if (matrix[row][mid] < target) {
                left = mid + 1;
            }

            // Search in the left half
            else {
                right = mid - 1;
            }
        }

        // Target not found
        return false;
    }
}
/*Problem:
Search a 2D Matrix (LC 74)

Pattern:
Binary Search

Idea:

• First Binary Search:
      Find the row where the target can exist.

• Second Binary Search:
      Search the target in that row.

Algorithm:

1. Binary Search on rows.
2. If row not found → Return false.
3. Binary Search on columns of that row.
4. Return true if found, else false.

Time Complexity:
O(log m + log n)

Reason:
One Binary Search on rows and one on columns.

Space Complexity:
O(1)

Reason:
Only constant extra variables are used.

Key Observation:

• Each row is sorted.
• First element of every row is greater than the last element of the previous row.
  MEMORY TRICK
  --------------------
  Step 1:
Find the Correct Row
(Row Binary Search)

↓

Step 2:
Find the Target
(Column Binary Search)

↓

Return true / false*/
