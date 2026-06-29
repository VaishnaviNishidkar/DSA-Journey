class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int sum =0;
        int minLength=Integer.MAX_VALUE;

    for (int right=0;right<nums.length;right++){
        sum+=nums[right];

        while(sum>=target){

            minLength=Math.min(minLength,right-left+1);
            sum-=nums[left];
            left++;
        }
    }
    return  minLength== Integer.MAX_VALUE ? 0:minLength;
    }
}
//brute force 
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int minLength = Integer.MAX_VALUE;

        // Choose every element as starting point
        for(int i = 0; i < nums.length; i++) {

            int sum = 0;

            // Extend the subarray
            for(int j = i; j < nums.length; j++) {

                sum += nums[j];

                // Check if target is reached
                if(sum >= target) {

                    minLength = Math.min(minLength, j - i + 1);

                    break;   // No need to extend further
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}/*
Problem: Minimum Size Subarray Sum

Approach: Variable Size Sliding Window

Idea:
- Expand the window by moving the right pointer.
- Keep adding elements to the current sum.
- Once sum >= target:
      Try to shrink the window from the left
      while maintaining sum >= target.
- Update the minimum window length.

Pattern Used:

- Sliding Window
- Variable Size Window

Algorithm:

1. Initialize:
      left = 0
      sum = 0
      minLength = Integer.MAX_VALUE

2. Traverse using right pointer:
      Add nums[right] to sum.

3. While sum >= target:
      Update minimum length.
      Remove nums[left] from sum.
      Move left pointer.

4. If no valid window exists:
      Return 0
   Else:
      Return minLength

Dry Run Example:

Input:

target = 7
nums = [2,3,1,2,4,3]

Window Expansion:

[2]
sum = 2

[2,3]
sum = 5

[2,3,1]
sum = 6

[2,3,1,2]
sum = 8

Valid Window

Length = 4

Shrink:

[3,1,2]
sum = 6

Expand:

[3,1,2,4]
sum = 10

Shrink:

[1,2,4]
sum = 7

Length = 3

Shrink:

[2,4]
sum = 6

Expand:

[2,4,3]
sum = 9

Shrink:

[4,3]
sum = 7

Length = 2 ✅

Output:

2

Time Complexity:

O(n)

Reason:
Each element enters and leaves the window at most once.

Space Complexity:

O(1)

Reason:
Only constant extra variables are used.

Key Observation:

Expand window
↓

When condition becomes true
(sum >= target)

↓

Shrink window to find
minimum valid length.

Mental Model:

Expand → Achieve Target
Shrink → Minimize Window
*/
