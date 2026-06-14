class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;
        int windowSum = 0;

        for(int i=0;i<k;i++){
            windowSum += nums[i];
        }

        int maxAns = windowSum;

        for(int j=k;j<n;j++){

            windowSum += nums[j];
            windowSum = windowSum - nums[j-k];

            maxAns = Math.max(maxAns,windowSum);
        }

        return maxAns;
    }
}
/*Problem:
Maximum Sum Subarray of Size K

Pattern:
Fixed Size Sliding Window

Formula:

windowSum = windowSum
          + incomingElement
          - outgoingElement

Time Complexity:
O(n)

Space Complexity:
O(1)

When To Use:
- Fixed window size given
- Maximum/Minimum sum of size K
- Average of size K


Time Complexity: O(n)

Reason:
- First window calculation takes O(k)
- Sliding remaining windows takes O(n-k)

Overall:
O(k + n-k)
= O(n)

Space Complexity: O(1)

Reason:
Only constant extra variables are used.
No extra array, list, map, or set is created.
*/
