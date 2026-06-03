/*
Problem: Missing Number Using XOR Pattern

Approach: XOR Cancellation Technique

Idea:
- XOR all numbers from range [0,n]
- XOR all elements present in array
- Same numbers cancel each other
- Remaining number is the missing element

Important XOR Properties:

a ^ a = 0
a ^ 0 = a
XOR is commutative:
a ^ b = b ^ a

This means duplicate numbers disappear automatically.

Algorithm:

1. Initialize:
      allXOR = 0

2. XOR all numbers from 0 to n

      for(i=0 to n)
          allXOR ^= i

3. XOR all elements of array

      for(num : nums)
          allXOR ^= num

4. Return allXOR

Pattern Used:

- Bit Manipulation
- XOR Cancellation Pattern

Dry Run Example:

Input:

nums = [3,0,1]

Step 1:

XOR range [0,n]

0 ^ 1 ^ 2 ^ 3

= 0

allXOR = 0

Step 2:

XOR array elements

0 ^ 3 = 3
3 ^ 0 = 3
3 ^ 1 = 2

Remaining:

2

Output:

Missing Number = 2

Visualization:

Range XOR:

0 ^ 1 ^ 2 ^ 3

Array XOR:

3 ^ 0 ^ 1

Cancellation:

0^0 -> removed
1^1 -> removed
3^3 -> removed

Only:

2 remains

Time Complexity:

O(n)

Reason:

Two linear traversals.

Space Complexity:

O(1)

Reason:

Uses only one variable.

Key Observation:

Numbers appearing twice vanish.

Only odd occurring / missing value survives.

When To Use:

- Missing Number
- Single Number
- Find Unique Element
- Duplicate Cancellation Problems
- Bit Manipulation Questions

Mental Model:

XOR acts like a magic eraser 🧽

Same numbers appear twice:

erase

Remaining number:

answer
*/
class Solution {
    public int missingNumber(int[] nums) {
        int allXOR=0;

    //XOR all numbers given in range [0,n]
        for(int i=0;i<=nums.length;i++){
            allXOR=allXOR^i;

        }
        //XOR all numbers in given array
        for(int num:nums){
            allXOR=allXOR^num;
        }
        //Missing no
        return allXOR;
    }
}
//another approach 
/*class Solution {

    public int missingNumber(int[] nums) {

        int n = nums.length;

        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;

        for(int num : nums){
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}*/
