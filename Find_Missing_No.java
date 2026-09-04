//Brute force 
class Solution {
    int missingNum(int[] arr) {
        int n = arr.length + 1;              // Original range is 1 to n

        int total = n * (n + 1) / 2;         // Sum of numbers from 1 to n

        int sum = 0;                         // Store sum of array elements
        for (int i = 0; i < arr.length; i++) { // Traverse the array
            sum += arr[i];                   // Add current element to sum
        }

        return total - sum;                  // Difference is the missing number
    }
}
/*Pattern: Array + Mathematical Sum
Logic: Missing = Sum(1 to n) - Sum(array)
Formula: n × (n + 1) / 2
TC: O(n)
SC: O(1)
Memory Trick: Expected Sum − Actual Sum = Missing Number

Example: [8,2,4,5,3,7,1]

n = 8
Total = 8 × 9 / 2 = 36
Array sum = 30
Missing = 36 − 30 = 6 ✅*/


//optimal
class Solution {
    public int missingNumber(int[] nums) {
        int allXOR = 0;                         // Store XOR of all numbers

        for (int i = 0; i <= nums.length; i++) { // XOR numbers from 0 to n
            allXOR = allXOR ^ i;               // XOR current number
        }

        for (int i = 0; i < nums.length; i++) { // Traverse given array
            allXOR = allXOR ^ nums[i];         // XOR array elements
        }

        return allXOR;                         // Remaining number is missing
    }
}
/*Short Revision Note 📝

Problem: Missing Number
Pattern: XOR
Idea: XOR complete range with array elements. Duplicate numbers cancel, missing number remains.

Key Observation: x ^ x = 0

TC: O(n)
SC: O(1)

Memory Trick:
XOR all expected numbers + XOR all array numbers = Missing number 🔑*/
