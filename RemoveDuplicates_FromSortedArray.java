class Solution {
    public int removeDuplicates(int[] nums) {
     if(nums.length<=1) return nums.length;

      int index=1;
      
      for(int i=1;i<nums.length;i++){
        if(nums[index-1]!=nums[i]){
          nums[index]=nums[i];
          index++;
        }
      }
      return index;
          }
}
/*
Problem: Remove Duplicates from Sorted Array

Approach: Two Pointer Technique

Idea:
- Since array is sorted, duplicates are adjacent.
- Use one pointer (i) to scan the array.
- Use another pointer (index) to track position where next unique element should be placed.
- If current element is different from previous unique element:
      place it at index position
      increment index

Algorithm:
1. If array size <= 1, return length.
2. Initialize index = 1
   (first element is always unique)
3. Traverse from i = 1 to n-1
4. Compare:
      nums[index-1] with nums[i]
5. If different:
      nums[index] = nums[i]
      index++
6. Return index

Pattern Used:
- Two Pointers
- In-place Array Modification

Dry Run Example:

Input:
[1,1,2,2,3]

Steps:

index = 1

i=1 → duplicate → skip
i=2 → unique → nums[1]=2 → index=2
i=3 → duplicate → skip
i=4 → unique → nums[2]=3 → index=3

Output:
Unique count = 3
Array = [1,2,3,...]

Time Complexity:
O(n)

Reason:
Single traversal of array.

Space Complexity:
O(1)

Reason:
No extra array used.
Only constant extra variables.

Key Observation:
Returned index = Number of unique elements.

When to Use:
- Sorted arrays
- Duplicate removal
- In-place modification problems
*/
