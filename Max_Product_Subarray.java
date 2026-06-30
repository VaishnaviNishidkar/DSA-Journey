//brute force 
class Solution {
    public int maxProduct(int[] nums) {
        int n =nums.length;
        int maxAns=-10;

        for (int i=0;i<n;i++){
            int prod=1;
            for(int j=i;j<n;j++){
                prod*=nums[j];
                maxAns=Math.max(maxAns,prod);
            }
        }
        return maxAns;
    }
}
//optimal soln
class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;

        int prefix = 1;
        int suffix = 1;

        int maxAns = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {

            // Reset if product becomes 0
            if(prefix == 0)
                prefix = 1;

            if(suffix == 0)
                suffix = 1;

            // Left to Right
            prefix *= nums[i];

            // Right to Left
            suffix *= nums[n - 1 - i];

            // Maximum product so far
            maxAns = Math.max(maxAns, Math.max(prefix, suffix));
        }

        return maxAns;
}
  2: Maximum Product Subarray.

/*
Problem: Maximum Product Subarray (LeetCode 152)

Approach: Prefix Product + Suffix Product

Idea:
- Traverse the array from both directions simultaneously.
- Calculate:
      Prefix Product (Left → Right)
      Suffix Product (Right → Left)
- Reset product to 1 whenever it becomes 0.
- Update the maximum product using both prefix and suffix.

Pattern Used:

- Prefix Product
- Suffix Product
Time Complexity:

O(n)

Reason:
Single traversal of the array.
Prefix and suffix products are computed in one loop.

Space Complexity:

O(1)

Reason:
Only constant extra variables are used.*/
  
