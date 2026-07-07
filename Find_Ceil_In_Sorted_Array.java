class Solution {
    public int findCeil(int[] arr, int x) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;    // Stores the index of the ceil

        while (left <= right) {

            // Find the middle index
            int mid = left + (right - left) / 2;

            // Possible ceil found
            if (arr[mid] >= x) {
                ans = mid;          // Store current index
                right = mid - 1;    // Search for a smaller valid ceil
            } else {
                // Current element is smaller than x
                left = mid + 1;     // Search in the right half
            }
        }

        // Return the index of the ceil
        return ans;
    }
}
/*Idea:

• Ceil = Smallest element ≥ x.
• If arr[mid] ≥ x:
      Store mid as answer.
      Move LEFT to find a smaller valid ceil.
• If arr[mid] < x:
      Move RIGHT.

Algorithm:

1. Initialize:
      left = 0
      right = n - 1
      ans = -1

2. While(left <= right):
      mid = left + (right-left)/2

      If arr[mid] ≥ x:
          ans = mid
          right = mid - 1

      Else:
          left = mid + 1

3. Return ans.

Time Complexity:
O(log n)

Reason:
Binary Search halves the search space in every iteration.

Space Complexity:
O(1)

Reason:
Only constant extra variables are used.

Key Observation:

• Ceil is the smallest element ≥ x.
• After finding a valid ceil, always search LEFT for a smaller valid ceil.
🧠 Memory Trick
Ceil (≥ x)

arr[mid] ≥ x
      ↓
Store ans
Move Left
(right = mid - 1)

arr[mid] < x
      ↓
Move Right
(left = mid + 1)*/
