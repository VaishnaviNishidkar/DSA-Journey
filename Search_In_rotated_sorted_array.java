class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            // Right half is sorted
            else {

                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
/*Problem:
Search in Rotated Sorted Array (LC 33)

Pattern:
Modified Binary Search

Idea:

• In every iteration, one half of the array is always sorted.
• Identify the sorted half.
• Check whether the target lies inside that sorted half.
• If yes, search that half.
• Otherwise, search the other half.

Algorithm:

1. left = 0, right = n - 1
2. While(left <= right):
      mid = left + (right - left) / 2

      If nums[mid] == target:
            Return mid

      If left half is sorted
      (nums[left] <= nums[mid]):

            If target lies in left half:
                  right = mid - 1
            Else:
                  left = mid + 1

      Else (right half is sorted):

            If target lies in right half:
                  left = mid + 1
            Else:
                  right = mid - 1

3. Return -1

Time Complexity:
O(log n)

Reason:
Binary Search eliminates half of the search space in every iteration.

Space Complexity:
O(1)

Reason:
Only constant extra variables are used.

Key Observation:

• One half of the rotated array is always sorted.
• First identify the sorted half.
• Then decide whether the target belongs to that half.*/
