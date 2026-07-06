class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;

            if(nums[mid]<nums[right]){
                right=mid;
            }else{
                left=mid+1;

            }
        }
        return nums[right];   // here u can also write nums[left]
        
    }
}
/*Problem:
Find Minimum in Rotated Sorted Array (LC 153)

Pattern:
Modified Binary Search

Idea:

• The array is sorted but rotated.
• Compare nums[mid] with nums[right].
• If nums[mid] < nums[right]:
      Minimum lies in the left half (including mid).
• Else:
      Minimum lies in the right half (excluding mid).
• Continue until left == right.

Algorithm:

1. left = 0, right = n - 1
2. While(left < right):
      mid = left + (right - left) / 2

      If nums[mid] < nums[right]:
            right = mid
      Else:
            left = mid + 1

3. Return nums[left] (or nums[right]).

Time Complexity:
O(log n)

Reason:
Binary Search halves the search space in every iteration.

Space Complexity:
O(1)

Reason:
Only constant extra variables are used.

Key Observation:

• Compare mid with the rightmost element.
• Right half sorted?
      Minimum is on the left (including mid).
• Left half sorted?
      Minimum is on the right (excluding mid).
• When left == right, it points to the minimum element.

                              //MEMORY TRICK
                              -----------------
            Compare nums[mid] with nums[right]

nums[mid] < nums[right]
        ↓
Right half is sorted
Minimum is on LEFT (including mid)
right = mid

nums[mid] > nums[right]
        ↓
Minimum is on RIGHT
left = mid + 1

Stop when:
left == right

Answer = nums[left]*/
