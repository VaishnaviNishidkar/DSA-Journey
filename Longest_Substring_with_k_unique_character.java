//optimal soln
class Solution {
    public int longestKSubstr(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int distinct = 0;
        int maxLen = -1;

        for (int right = 0; right < s.length(); right++) {

            // Current character
            char ch = s.charAt(right);

            // If character appears for the first time
            if (freq[ch - 'a'] == 0) {
                distinct++;
            }

            // Increase frequency
            freq[ch - 'a']++;

            // Shrink window if distinct characters become more than k
            while (distinct > k) {

                char remove = s.charAt(left);

                freq[remove - 'a']--;

                // Character completely removed
                if (freq[remove - 'a'] == 0) {
                    distinct--;
                }

                left++;
            }

            // Update answer when exactly k distinct characters exist
            if (distinct == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}
/*Problem:
Longest Substring with Exactly K Distinct Characters

Pattern:
Sliding Window + Frequency Array

Idea:

• Use freq[26] to store frequency.
• Use distinct to count unique characters.
• Expand window by moving right.
• If distinct > k:
      Shrink window from left.
• If distinct == k:
      Update maximum length.

Algorithm:

1. freq[26]
2. left = 0
3. distinct = 0
4. Expand right
5. New character → distinct++
6. While(distinct > k):
      Remove left character
      If frequency becomes 0:
            distinct--
      left++
7. If(distinct == k):
      Update answer

Time Complexity:
O(n)

Space Complexity:
O(1)

Reason:
Frequency array has fixed size (26).*/

//brute force
class Solution {
    public int longestKSubstr(String s, int k) {

        // Length of the string
        int n = s.length();

        // Stores the maximum length found
        // Initialize with -1 because answer may not exist
        int maxLen = -1;

        // Choose every index as the starting point
        for (int i = 0; i < n; i++) {

            // HashSet stores distinct characters
            Set<Character> set = new HashSet<>();

            // Extend the substring from index i
            for (int j = i; j < n; j++) {

                // Add current character to the set
                // Duplicate characters are ignored automatically
                set.add(s.charAt(j));

                // If exactly k distinct characters exist
                // update the maximum length
                if (set.size() == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }

                // If distinct characters become more than k,
                // no need to extend this substring further
                else if (set.size() > k) {
                    break;
                }
            }
        }

        // Return the longest substring length
        // or -1 if no valid substring exists
        return maxLen;
    }
}
