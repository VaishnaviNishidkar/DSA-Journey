class Solution {
    public boolean isPalindrome(int n) {

        // Convert negative number to positive
        n = Math.abs(n);

        // Convert number to String for easy comparison
        String str = String.valueOf(n);

        // Check palindrome using recursion
        return check(str, 0, str.length() - 1);
    }

    boolean check(String str, int left, int right) {

        // Base Case:
        // If pointers have met or crossed, all characters matched
        if (left >= right) {
            return true;
        }

        // Characters do not match
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        // Check remaining substring
        return check(str, left + 1, right - 1);
    }
}
/*Problem:
Palindrome Number

Pattern:
Recursion + Two Pointers

Idea:

• Compare first and last characters.
• If they match, move inward.
• If they don't match, return false.
• Stop when left >= right.

Algorithm:

1. Convert number to String.
2. Compare str[left] and str[right].
3. If equal:
      left++
      right--
4. Repeat recursively.
5. Return true when left >= right.

Time Complexity:
O(n)

Reason:
Each character is checked once.

Space Complexity:
O(n)

Reason:
Recursive call stack stores n/2 calls.

Key Observation:

• left < right → Keep comparing.
• left == right → Middle character reached (odd length).
• left > right → All pairs checked (even length).
• Therefore, stop when left >= right.
🧠 Memory Trick
Compare Ends

Match?
   ↓
Move Inward

left >= right
      ↓
Palindrome*/
