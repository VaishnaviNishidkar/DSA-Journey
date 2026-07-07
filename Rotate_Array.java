//LC_189
class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int n=arr.length;
        int [] temp= new int [n];
        
        for(int i=0;i<n;i++){
            int newIndex=(i+k)%n;
            temp[newIndex]=arr[i];
            
        }
        for(int i=0;i<n;i++){
            arr[i]=temp[i];
        }
    }
}
/*Problem:
Rotate Array (LC 189)

Pattern:
Extra Array

Idea:

• Move every element to its new position.
• New index = (i + k) % n
• Store elements in a temporary array.
• Copy the temporary array back to the original array.

Algorithm:

1. Create temp array of size n.
2. For every index i:
      newIndex = (i + k) % n
      temp[newIndex] = arr[i]
3. Copy temp[] back to arr[].

Time Complexity:
O(n)

Reason:
One traversal to fill temp[] and one traversal to copy back.

Space Complexity:
O(n)

Reason:
Uses an extra temporary array.

Key Observation:

• (i + k) % n wraps the index to the beginning when it exceeds the array size.


    Memory Trick
Current Index (i)
        ↓
New Index = (i + k) % n
        ↓
Store in temp[]
        ↓
Copy temp[] → arr[]
    */
