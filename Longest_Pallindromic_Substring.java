//brute force
class Solution {

    public String longestPalindrome(String s) {

        // Store length of the string
        int n = s.length();

        // Stores the longest palindrome found so far
        String result = "";

        // Choose every character as the starting index
        for (int i = 0; i < n; i++) {

            // Choose every possible ending index
            for (int j = i; j < n; j++) {

                // Check whether substring s[i...j] is a palindrome
                if (isPalindrome(s, i, j)) {

                    // Update result only if current palindrome is longer
                    if ((j - i + 1) > result.length()) {

                        // Store the current longest palindrome
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }

        // Return the longest palindromic substring
        return result;
    }

    // Helper function to check if substring s[left...right] is a palindrome
    private boolean isPalindrome(String s, int left, int right) {

        // Compare characters from both ends
        while (left < right) {

            // If mismatch is found, it is not a palindrome
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            // Move both pointers toward the center
            left++;
            right--;
        }

        // All characters matched
        return true;
    }
}
//optimal approach 
class Solution {

    public String longestPalindrome(String s) {

        int n = s.length();

        int start = 0;
        int end = 0;

        for(int i = 0; i < n; i++){

            // Odd length palindrome
            int len1 = expand(s, i, i);

            // Even length palindrome
            int len2 = expand(s, i, i + 1);

            // Longer palindrome
            int len = Math.max(len1, len2);

            if(len > end - start){

                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right){

        while(left >= 0 &&
              right < s.length() &&
              s.charAt(left) == s.charAt(right)){

            left--;
            right++;
        }

        return right - left - 1;
    }
}
/*Problem:
Longest Palindromic Substring (LC 5)

Pattern:
Expand Around Center

Idea:

• Every character can be the center of a palindrome.
• Expand outward while both characters are equal.
• Check both:
      Odd-length palindrome (i, i)
      Even-length palindrome (i, i+1)
• Keep track of the longest palindrome found.

Algorithm:

1. Initialize:
      start = 0
      end = 0

2. For every index i:
      • Find odd-length palindrome.
      • Find even-length palindrome.
      • Take the maximum length.
      • Update start and end if a longer palindrome is found.

3. Return substring(start, end + 1).

Expand Function:

• While:
      left >= 0
      right < s.length()
      s[left] == s[right]

      Expand outward:
      left--
      right++

• Return palindrome length:
      right - left - 1

Time Complexity:
O(n²)

Reason:
Expand from each character (2n centers),
and each expansion may take O(n).

Space Complexity:
O(1)

Reason:
Only pointers and variables are used.

Key Observation:

Every palindrome has a center.

Odd Palindrome:
expand(i, i)

Even Palindrome:
expand(i, i + 1)

Check both and keep the longest one.*/
