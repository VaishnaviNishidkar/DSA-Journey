class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}
/*Problem:
Search Insert Position (LC 35)

Pattern:
Binary Search

Idea:

• Search for the target in the sorted array.
• If found, return its index.
• If not found, return the position where it should be inserted.
• Binary Search automatically narrows down the correct insertion point.

Algorithm:

1. left = 0, right = n - 1
2. While(left <= right):
      mid = left + (right - left) / 2
      If nums[mid] == target:
            Return mid
      Else if nums[mid] < target:
            left = mid + 1
      Else:
            right = mid - 1
3. Return left.

Time Complexity:
O(log n)

Reason:
Binary Search halves the search space in every iteration.

Space Complexity:
O(1)

Reason:
Only constant extra variables (left, right, mid) are used.

Key Observation:

• If target exists → Return its index.
• If target doesn't exist → left points to the correct insertion position after the loop ends.*/
