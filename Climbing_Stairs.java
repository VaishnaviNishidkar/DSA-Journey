class Solution {
    public int climbStairs(int n) {
         if(n<=2){
            return n;
        }
        int prev0=1;
        int prev1=2;
        for(int i=3;i<=n;i++){
            int temp=prev0+prev1;
            prev0=prev1;
            prev1=temp;
        }
        return prev1;
        
    }
}
/*
Time Complexity:
O(n)

Reason:
Traverse from 3 to n once.

Space Complexity:
O(1)

Reason:
Only three variables (prev0, prev1, temp) are used.

Key Observation:

• Base Cases:
      n = 1 → 1 way
      n = 2 → 2 ways

• To reach step n:
      Come from (n-1) or (n-2).

• Same recurrence as the Fibonacci sequence*/
