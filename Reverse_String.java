//Using stringbuilder
class Solution {
    public void reverseString(char[] s) {
        StringBuilder reverse = new StringBuilder(new String(s)).reverse();
        for(int i=0;i<s.length;i++){
            s[i]=reverse.charAt(i);
        }
        
    }
}
/*Problem:
Reverse String (LC 344)

Pattern:
StringBuilder

Idea:

• Convert char[] → String.
• Create StringBuilder.
• Reverse using reverse().
• Copy characters back into char[].

Algorithm:

1. new String(s)
2. new StringBuilder(...)
3. reverse()
4. Copy back using a loop.

Time Complexity:
O(n)

Space Complexity:
O(n)

Key Observation:

Uses extra memory because
a new String and StringBuilder
are created.*/

//using swap + two pointer
class Solution {
    public void reverseString(char[] s) {

        int n= s.length;
        int left=0;
        int right=n-1;
        while(left<right){
            char ch = s[left];
            s[left]=s[right];
            s[right]=ch;

            left++;
            right--;
        }
         }
}

/*Problem:
Reverse String (LC 344)

Pattern:
Two Pointer

Idea:

• One pointer starts from the left.
• One pointer starts from the right.
• Swap both characters.
• Move pointers inward.
• Repeat until left < right.

Algorithm:

1. left = 0
2. right = n - 1
3. While(left < right):
      Swap
      left++
      right--
4. Array is reversed in-place.

Time Complexity:
O(n)

Space Complexity:
O(1)

Key Observation:

Reverse the array by swapping
the first and last elements,
then continue moving inward
until left < right becomes false.*/
