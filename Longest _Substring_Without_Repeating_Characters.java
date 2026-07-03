class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set= new HashSet<>();

        int left=0;
        int maxLen=0;
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
        maxLen=Math.max(maxLen,right-left+1);
        }
        
       return maxLen;  
    }
   
}
/*Problem:
Longest Substring Without Repeating Characters (LC 3)

Pattern:
Sliding Window + HashSet

Idea:

• Expand the window using the right pointer.
• Store unique characters in a HashSet.
• If a duplicate is found:
      Remove characters from the left
      until the duplicate is removed.
• Update the maximum window length.

Algorithm:

1. Create a HashSet.
2. left = 0
3. Traverse using right pointer.
4. While duplicate exists:
      Remove left character.
      left++
5. Add current character.
6. Update maxLen.

Time Complexity:
O(n)

Reason:
Each character is added and removed
from the HashSet at most once.

Space Complexity:
O(min(n, charset))

Reason:
HashSet stores unique characters
present in the current window.

//memmory trick
Expand Window
      ↓
Duplicate Found?
      ↓
Yes
      ↓
Remove from Left
      ↓
Unique Again?
      ↓
Add Current Character
      ↓
Update Maximum Length
      ↓
Repeat




*/
