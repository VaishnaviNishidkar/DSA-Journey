//brute force
class Solution {
    public int countSubstrings(String s) {
        
    int n=s.length();
    int count=0;

    for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            if(isPallindrome(s,i,j)){
                count++;
            }
        }
    }
    return count;
    }
    private boolean isPallindrome(String s ,int left,int right){
        while(left<right){
            if(s.charAt(left) !=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

//optimal approach
class Solution {

    public int countSubstrings(String s) {

        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {

            // Odd length palindromes
            count += expand(s, i, i);

            // Even length palindromes
            count += expand(s, i, i + 1);
        }

        return count;
    }

    private int expand(String s, int left, int right) {

        int count = 0;

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            count++;

            left--;
            right++;
        }

        return count;
    }
  
}
/*Problem:
Palindromic Substrings (LC 647)

Pattern:
Expand Around Center

Idea:

• Every character can be the center of a palindrome.
• Expand outward while both characters are equal.
• Count every valid palindrome found.
• Check both:
      Odd-length palindrome (i, i)
      Even-length palindrome (i, i+1)

Algorithm:

1. Initialize count = 0.
2. For every index i:
      • count += expand(i, i)
      • count += expand(i, i+1)
3. Return count.

Expand Function:

• While:
      left >= 0
      right < s.length()
      s[left] == s[right]

      • Count current palindrome.
      • Expand outward:
            left--
            right++

• Return count.

Time Complexity:
O(n²)

Reason:
Expand from every possible center.

Space Complexity:
O(1)

Reason:
Only pointers and a counter are used.

Key Observation:

Every successful expansion forms one palindrome.

Odd Center:
expand(i, i)

Even Center:
expand(i, i + 1)

Total Palindromes =
Odd Count + Even Count*/
