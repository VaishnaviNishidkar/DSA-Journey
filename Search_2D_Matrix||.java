class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Number of rows
        int m = matrix.length;

        // Number of columns
        int n = matrix[0].length;

        // Start from the top-right corner
        int r = 0;
        int c = n - 1;

        // Traverse until we go out of bounds
        while (r < m && c >= 0) {

            // Target found
            if (matrix[r][c] == target) {
                return true;
            }

            // Current element is greater than target
            // Move LEFT to smaller values
            else if (matrix[r][c] > target) {
                c-=1;
            }

            // Current element is smaller than target
            // Move DOWN to larger values
            else {
                r+=1;
            }
        }

        // Target not present in the matrix
        return false;
    }
}
/*Problem:
Search a 2D Matrix II (LC 240)

Pattern:
Staircase Search (Top-Right Corner)

Idea:

• Start from the top-right element.
• If current element == target:
      Return true.
• If current element > target:
      Move LEFT.
• If current element < target:
      Move DOWN.
• Repeat until target is found or indices go out of bounds.

Algorithm:

1. Start at (row = 0, col = n-1).
2. While row < m and col >= 0:
      If matrix[row][col] == target:
          Return true.
      Else if matrix[row][col] > target:
          col--
      Else:
          row++
3. Return false.

Time Complexity:
O(m + n)

Reason:
At each step, either one row or one column is eliminated.

Space Complexity:
O(1)

Reason:
Only constant extra variables (row and col) are used.

Key Observation:

• Rows are sorted left → right.
• Columns are sorted top → bottom.
• Top-right corner helps eliminate one row or one column in each step.

      MEMORY TRICK
  ---------------------
  Start at Top-Right

Current > Target
      ↓
Move LEFT (c--)

Current < Target
      ↓
Move DOWN (r++)

Current == Target
      ↓
Return true*/
