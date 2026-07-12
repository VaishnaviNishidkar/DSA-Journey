class Solution {
    public int fib(int n) {
        if(n<=1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}
/*
Key Observation:

• Base case:
      fib(0) = 0
      fib(1) = 1
• Every Fibonacci number is the sum of the previous two numbers.*/

class Solution {
    public int fib(int n) {
        if(n<=1){
            return n;
        }
        int prev0=0;
        int prev1=1;
        for(int i=2;i<=n;i++){
            int temp=prev0+prev1;
            prev0=prev1;
            prev1=temp;
        }
        return prev1;
    }
}

/*Time Complexity:
O(n)

Reason:
Traverse from 2 to n once.

Space Complexity:
O(1)

Reason:
Only three variables (prev0, prev1, temp) are used.
🧠 Memory Trick
prev0 + prev1
      ↓
    temp

prev0 = prev1
prev1 = temp

Repeat until n
  */
