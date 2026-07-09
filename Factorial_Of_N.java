//using recursion
class Solution {
    int factorial(int n) {
        // code here
        if(n==0 || n==1){
            return 1;
        }
        
        return n*factorial(n-1);
    }
}
/*Idea:

• Factorial of n = n × factorial(n-1).
• Keep calling the function until n becomes 0 or 1.
• 0! = 1 and 1! = 1 (Base Case).

Algorithm:

1. If n == 0 or n == 1:
      Return 1.
2. Else:
      Return n × factorial(n-1).

Time Complexity:
O(n)

Reason:
One recursive call is made for each value from n to 1.

Space Complexity:
O(n)

Reason:
Recursive call stack stores n function calls.

Key Observation:

• Every recursive call reduces n by 1.
• Base case stops infinite recursion.
🧠 Memory Trick
factorial(5)

5 × factorial(4)
      ↓
4 × factorial(3)
      ↓
3 × factorial(2)
      ↓
2 × factorial(1)
      ↓
1 (Base Case)

Answer = 5 × 4 × 3 × 2 × 1 = 120*/
