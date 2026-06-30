//bbrute force 
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int n=  nums.length;
        for(int i=0;i<n;i++){
            int sum =0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                maxSum=Math.max(maxSum,sum);

            }
        }
        return maxSum;
        
    }
}
//optimal soln
/*
Problem: Maximum Subarray (LeetCode 53)

Approach: Kadane's Algorithm

Idea:
- Keep adding elements to the current subarray.
- If the current sum becomes negative, discard it because
  a negative sum will only decrease the sum of future subarrays.
- Keep track of the maximum sum seen so far.
*/
/*
Problem: Maximum Subarray (LeetCode 53)

Approach: Kadane's Algorithm

Idea:
- Keep adding elements to the current subarray.
- If the current sum becomes negative, discard it because
  a negative sum will only decrease the sum of future subarrays.
- Keep track of the maximum sum seen so far.
*/

class Solution {
    public int maxSubArray(int[] nums) {

        // Stores the maximum subarray sum found so far.
        // Initialize with nums[0] to correctly handle
        // arrays containing all negative numbers.
        int maxSum = nums[0];

        // Stores the sum of the current subarray.
        int currentSum = 0;

        // Traverse every element in the array.
        for (int num : nums) {

            // Extend the current subarray
            // by adding the current element.
            currentSum += num;

            // Update the maximum sum if the current
            // subarray has a larger sum.
            maxSum = Math.max(maxSum, currentSum);

            // If the current sum becomes negative,
            // it cannot help any future subarray.
            // Start a new subarray from the next element.
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        // Return the maximum subarray sum.
        return maxSum;
    }
}
/*Time Complexity:

O(n)

Reason:
Single traversal of the array.

Space Complexity:

O(1)

Reason:
Only two variables are used.*/

