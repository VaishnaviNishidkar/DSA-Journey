class Solution {
    public boolean validPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){

                return isPallindrome(s,left+1,right);
                 return isPallindrome(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean isPallindrome(String s, int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
/*Problem:
Valid Palindrome II (LC 680)

Pattern:
Two Pointer + Helper Function

Idea:

• Use two pointers:
      left → Start
      right → End
• If characters match:
      Move both pointers.
• If characters don't match:
      Try deleting either:
      1. Left character
      2. Right character
• If either remaining substring is a palindrome,
  return true.

Algorithm:

1. left = 0, right = n - 1
2. While(left < right):
      If s[left] == s[right]:
            left++
            right--
      Else:
            return isPalindrome(left + 1, right) ||
                   isPalindrome(left, right - 1)
3. Return true.

Helper Function:

• Check whether the substring
  between left and right is a palindrome.

Time Complexity:
O(n)

Reason:
At most one full scan of the string,
and one additional palindrome check.

Space Complexity:
O(1)

Reason:
Only pointers are used.

Key Observation:

Only one character can be removed.

On the first mismatch,
check both possibilities:
• Skip left character.
• Skip right character.

If either forms a palindrome,
the answer is true.*/
