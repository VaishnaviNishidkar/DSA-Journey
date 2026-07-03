class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // If s1 is longer than s2, permutation is impossible
        if (s1.length() > s2.length())
            return false;

        // Frequency array for s1
        int[] freq1 = new int[26];

        // Frequency array for current window in s2
        int[] freq2 = new int[26];

        // Store frequency of every character in s1
        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        // Left pointer of sliding window
        int left = 0;

        // Expand window using right pointer
        for (int right = 0; right < s2.length(); right++) {

            // Include current character in window
            freq2[s2.charAt(right) - 'a']++;

            // Keep window size equal to s1.length()
            if (right - left + 1 > s1.length()) {

                // Remove leftmost character
                freq2[s2.charAt(left) - 'a']--;

                // Move left pointer
                left++;
            }

            // Compare frequencies when window size equals s1 length
            if (right - left + 1 == s1.length()) {

                boolean isMatch = true;

                // Compare both frequency arrays
                for (int i = 0; i < 26; i++) {

                    if (freq1[i] != freq2[i]) {
                        isMatch = false;
                        break;
                    }
                }

                // Permutation found
                if (isMatch)
                    return true;
            }
        }

        // No permutation exists
        return false;
    }
}/*
Problem:
Permutation in String (LC 567)

Pattern:
Sliding Window + Frequency Array

Idea:

• Store frequency of s1.
• Create a window of size s1.length() in s2.
• Store frequency of the current window.
• Compare both frequency arrays.
• If they match, a permutation exists.

Algorithm:

1. Count frequency of s1.
2. Expand window in s2.
3. If window size exceeds s1.length():
      Remove left character.
      left++
4. When window size == s1.length():
      Compare both frequency arrays.
5. If equal → return true.
6. Otherwise continue.

Time Complexity:
O(26 × n)

Reason:
Sliding window runs O(n).
Each window comparison takes O(26),
which is constant.

Overall:
O(n)

Space Complexity:
O(1)

Reason:
Two fixed-size frequency arrays
of size 26.*/
