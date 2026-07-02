class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        List<Integer> result = new ArrayList<>();

        // Frequency of p
        for(char ch : p.toCharArray()){
            pCount[ch - 'a']++;
        }

        // Sliding Window
        for(int i = 0; i < s.length(); i++){

            sCount[s.charAt(i) - 'a']++;

            // Remove character outside the window
            if(i >= p.length()){
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // Compare frequency arrays
            if(Arrays.equals(pCount, sCount)){
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
  /*Problem:
Find All Anagrams in a String (LC 438)

Pattern:
Sliding Window + Frequency Array

Idea:

• Count the frequency of characters in p.
• Maintain a sliding window of the same size as p in s.
• Add the new character entering the window.
• Remove the character leaving the window.
• Compare both frequency arrays.
• If equal, store the starting index.

Algorithm:

1. Create two frequency arrays of size 26:
      pCount[]
      sCount[]

2. Store frequency of all characters in p.

3. Traverse s:
      • Add current character to sCount.
      • If window size exceeds p.length():
            Remove leftmost character.
      • Compare pCount and sCount.
      • If equal:
            Add starting index
            (i - p.length() + 1)

4. Return the result list.

Time Complexity:
O(n)

Reason:
Single traversal of s.
Comparing two arrays of size 26 takes O(26),
which is constant.

Space Complexity:
O(1)

Reason:
Only two fixed-size frequency arrays
of length 26 are used.

Key Observation:

The window size is always equal to p.length().

Instead of recounting frequencies for every substring,
update the window by:
• Adding one new character.
• Removing one old character.

Useful Methods:

Arrays.equals(arr1, arr2)
toCharArray()*/
}
