class Solution {
    int countFreq(int[] arr, int target) {

   
        int first = findFirst(arr, target);
        if(first==-1) return 0;
        int last = findLast(arr, target);

        return last-first+1;
    }

    private int findFirst(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private int findLast(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
        
   /*
Idea:

• Find the first occurrence of the target.
• Find the last occurrence of the target.
• Frequency = last - first + 1.
• If target is not found (first = -1), return 0.

Algorithm:

1. Find First Occurrence.
2. If first == -1:
      Return 0.
3. Find Last Occurrence.
4. Return (last - first + 1).

Time Complexity:
O(log n)

Reason:
Two Binary Searches.
O(log n) + O(log n) = O(log n)

Space Complexity:
O(1)

Reason:
Only constant extra variables used.

Key Observation:

• First occurrence → Move LEFT after finding target.
• Last occurrence → Move RIGHT after finding target.
• Frequency = Last Index - First Index + 1.

🧠 Memory Trick
First Occurrence
Found Target
     ↓
Store ans
Move Left
(right = mid - 1)

-----------------------

Last Occurrence
Found Target
     ↓
Store ans
Move Right
(left = mid + 1)

-----------------------

Frequency
= last - first + 1*/
