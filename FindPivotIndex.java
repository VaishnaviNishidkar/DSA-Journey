class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum =0;
        for(int num:nums){
            totalSum+=num;
        }

    int leftSum=0;
        for(int i=0;i<nums.length;i++){
            int rightSum=totalSum-leftSum-nums[i];

            if(leftSum==rightSum){
                return i;
            }
            leftSum+=nums[i];

        }
        return -1;
    }
}

/*
Problem: Find Pivot Index

Definition:
Pivot Index is the index where:

Sum of elements on left side
=
Sum of elements on right side

Approach: Prefix Sum

Idea:
- First calculate total sum of array.
- Maintain a running leftSum.
- For every index:
      rightSum = totalSum - leftSum - nums[i]
- If leftSum == rightSum:
      return current index

Algorithm:

1. Calculate totalSum of array.
2. Initialize:
      leftSum = 0
3. Traverse array:
      rightSum = totalSum - leftSum - nums[i]
4. Check:
      if(leftSum == rightSum)
          return i
5. Update:
      leftSum += nums[i]
6. If no pivot found:
      return -1

Pattern Used:

- Prefix Sum
- Running Sum

Dry Run Example:

Input:

nums = [1,7,3,6,5,6]

totalSum = 28

i=0
leftSum = 0
rightSum = 28-0-1 = 27
Not Equal

leftSum = 1

----------------

i=1
leftSum = 1
rightSum = 28-1-7 = 20
Not Equal

leftSum = 8

----------------

i=2
leftSum = 8
rightSum = 28-8-3 = 17
Not Equal

leftSum = 11

----------------

i=3
leftSum = 11
rightSum = 28-11-6 = 11

Equal ✅

Return 3

Output:

Pivot Index = 3

Visualization:

[1,7,3 | 6 | 5,6]

Left Sum  = 11
Right Sum = 11

Time Complexity:

O(n)

Reason:
- One pass to calculate totalSum
- One pass to find pivot

O(n) + O(n) = O(n)

Space Complexity:

O(1)

Reason:
Only constant extra variables used.

Variables:
- totalSum
- leftSum
- rightSum

Key Observation:

rightSum can be calculated instantly:

rightSum = totalSum - leftSum - nums[i]

No need for nested loops.

When To Use:

- Prefix Sum Problems
- Running Sum Problems
- Equal Left/Right Sum Questions
- Balance Point Problems

Mental Model:

At every index:

Array = Left Part + Current Element + Right Part

leftSum + nums[i] + rightSum = totalSum

Find the position where:

leftSum == rightSum
*/
