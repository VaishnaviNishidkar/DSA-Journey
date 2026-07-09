class Solution {
    public double myPow(double x, int n) {
        long pow = n;             // Store power in long to handle Integer.MIN_VALUE
        if (pow < 0) {            // If power is negative, take reciprocal of base and make power positive
            x = 1 / x;
            pow = -pow;
        }
        double ans = 1;           // Stores the final answer

        // Binary Exponentiation
        while (pow > 0) {
            if (pow % 2 == 1) {                         // If current power is odd, multiply current base to the answer
                ans *= x;
            }
            x *= x;                                              // Square the base for the next bit

            pow = pow / 2;                                       // Divide power by 2 (right shift)
        }
        return ans;                                                   // Return x raised to the power n
    }
}

//Recursive approch
class Solution {

    public double myPow(double x, int n) {

        long pow = n;                     // Store power as long to handle Integer.MIN_VALUE

        if (pow < 0) {                    // If power is negative
            x = 1 / x;                    // Take reciprocal of base
            pow = -pow;                   // Convert power to positive
        }

        return power(x, pow, 1);          // Start recursive Binary Exponentiation
    }

    double power(double x, long pow, double ans) {

        if (pow == 0) {                   // Base case: power becomes 0
            return ans;                   // Return accumulated answer
        }

        if (pow % 2 == 1) {               // If power is odd
            ans *= x;                     // Multiply current base to answer
        }

        return power(x * x, pow / 2, ans); // Square base, halve power, recurse
    }
}
/*Problem:
Pow(x, n)

Pattern:
Recursion + Binary Exponentiation

Idea:

• If exponent is odd:
      Multiply answer by current base.
• Square the base.
• Halve the exponent.
• Repeat until exponent becomes 0.

Time Complexity:
O(log n)

Space Complexity:
O(log n)

Key Observation:

• Exponent reduces by half in every recursive call.
• Squaring the base compensates for halving the exponent.*/
