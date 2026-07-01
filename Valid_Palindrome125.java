class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            if((ch >= 'a' && ch <= 'z') || 
               (ch >= '0' && ch <= '9')){

                sb.append(ch);
            }
        }

        for(int i = 0; i < sb.length()/2; i++){

            if(sb.charAt(i) != sb.charAt(sb.length()-1-i)){
                return false;
            }
        }

        return true;
    }
}

//another method 
class Solution {
    public boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {

            char left = s.charAt(l);
            char right = s.charAt(r);

            if (!Character.isLetterOrDigit(left)) {
                l++;
            }
            else if (!Character.isLetterOrDigit(right)) {
                r--;
            }
            else {

                if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                    return false;
                }

                l++;
                r--;
            }
        }

        return true;
    }
}
/*Problem:
Valid Palindrome (LC 125)

Pattern:
Two Pointer

Idea:

• Use two pointers:
      l → Start of string
      r → End of string
• Ignore non-alphanumeric characters.
• Compare characters after converting both to lowercase.
• If any mismatch occurs, return false.
• If pointers cross without mismatch, return true.

Algorithm:

1. l = 0, r = n - 1
2. While(l < r):
      • If left is not alphanumeric → l++
      • Else if right is not alphanumeric → r--
      • Else:
            Compare lowercase(left) and lowercase(right)
            If not equal → return false
            l++
            r--
3. Return true.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Observation:

Ignore spaces, punctuation, and special characters.
Compare only letters and digits in a case-insensitive manner.

Useful Methods:

Character.isLetterOrDigit(ch)
Character.toLowerCase(ch)*/
