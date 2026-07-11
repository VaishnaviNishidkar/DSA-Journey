class Solution {

    public int kthSmallest(int[][] mat, int k) {

        int n = mat.length;

        // Smallest element in the matrix
        int low = mat[0][0];

        // Largest element in the matrix
        int high = mat[n - 1][n - 1];

        // Binary Search on the answer
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Count elements <= mid
            int count = countLessEqual(mat, n, mid);

            if (count < k) {
                // Need larger values
                low = mid + 1;
            } else {
                // Possible answer, search smaller
                high = mid - 1;
            }
        }

        // kth smallest element
        return low;
    }

    // Counts how many elements are <= target
    private int countLessEqual(int[][] mat, int n, int target) {

        int row = n - 1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < n) {

            if (mat[row][col] <= target) {

                // All elements above this row are also <= target
                count += (row + 1);

                // Move to next column
                col++;
            } else {

                // Current element is too large
                row--;
            }
        }

        return count;
    }
}
/*Time Complexity: O(n × log(maxValue - minValue))
Space Complexity: O(1)*/
