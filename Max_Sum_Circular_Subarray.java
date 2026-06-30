class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum=0;
        int currMax=0;
        int maxSum=nums[0];
        int minSum=nums[0];
        int currMin=0;

        for(int num: nums){
            //Max value of max subarray sum
            currMax = Math.max(currMax+num,num);
            maxSum = Math.max(maxSum,currMax);

            //min value of subarray sum
            currMin=Math.min(currMin+num,num);
            minSum=Math.min(currMin,minSum);

            totalSum+=num;
            
        }
        return maxSum>0 ? Math.max(maxSum,totalSum-minSum) : maxSum;
    }
}
/*Problem:
Maximum Sum Circular Subarray (LC 918)

Pattern:
Kadane's Algorithm

Idea:

• Find Normal Maximum Subarray Sum.
• Find Minimum Subarray Sum.
• Calculate Total Sum.
• Circular Sum = Total Sum - Minimum Sum.
• Answer = max(Normal Max, Circular Sum).

Algorithm:

1. Track currMax and maxSum.
2. Track currMin and minSum.
3. Calculate totalSum.
4. If maxSum > 0:
      return max(maxSum, totalSum - minSum)
   Else:
      return maxSum

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Observation:

Normal Maximum =
Kadane's Maximum Sum

Circular Maximum =
Total Sum - Minimum Subarray Sum*/
