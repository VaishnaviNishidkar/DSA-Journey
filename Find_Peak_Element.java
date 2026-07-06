//approach -1 
class Solution {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;

        while(left<right){
            int mid= left+(right-left)/2;

            if(nums[mid]>nums[mid+1]){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return right;
    }
}
/*Idea:

• A peak element is greater than its adjacent elements.
• Compare nums[mid] with nums[mid + 1].
• If nums[mid] > nums[mid + 1]:
      Peak lies on the left side (including mid).
• Else:
      Peak lies on the right side.
• Continue until left == right.

Algorithm:

1. left = 0, right = n - 1
2. While(left < right):
      mid = left + (right - left) / 2

      If nums[mid] > nums[mid + 1]:
            right = mid
      Else:
            left = mid + 1

3. Return left (or right).

Time Complexity:
O(log n)

Reason:
Binary Search halves the search space in every iteration.

Space Complexity:
O(1)

Reason:
Only constant extra variables are used.
• If nums[mid] > nums[mid + 1]:
      Peak lies on the left half
      (including mid).
      right = mid
      
• When left == right,
      that index is a peak.
  */
//approach -2 
class Solution {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;

        while(left<right){
            int mid= left+(right-left+1)/2;

            if(nums[mid]>nums[mid-1]){
                left=mid;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
}
/*• If nums[mid] < nums[mid + 1]:
      Peak lies on the right half
      (excluding mid).
      left = mid + 1
*/
   //Memory trick 
-----------------------
/*
  Compare:

nums[mid]     nums[mid+1]

     7   >   5
      ↓
Descending Slope
Peak ← Left
right = mid

------------------------

     5   <   7
      ↓
Ascending Slope
Peak → Right
left = mid + 1

Stop when:
left == right
  */

Answer = left
