class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        int left=0;
        int right=arr.length-1;
        int ans=-1;
    
        while(left<=right){
            int mid =left+(right-left)/2;
            
            if(arr[mid]<=x){
                left=mid+1;
                ans=mid;
            }else{
                right=mid-1;
                
            }
        }
        return ans;
    }
}
/*Idea:

• Floor = Greatest element ≤ x.
• Whenever arr[mid] ≤ x:
      Store mid as a possible answer.
      Search on the RIGHT for a larger valid floor.
• If arr[mid] > x:
      Search on the LEFT.

Algorithm:

1. left = 0, right = n-1, ans = -1
2. While(left <= right):
      mid = left + (right-left)/2

      If arr[mid] <= x:
          ans = mid
          left = mid + 1
      Else:
          right = mid - 1

3. Return ans.

Time Complexity:
O(log n)

Reason:
Binary Search halves the search space in every iteration.

Space Complexity:
O(1)

Reason:
Only constant extra variables are used.

Key Observation:

• Whenever arr[mid] ≤ x, it can be the floor.
• Keep searching🧠 Memory Trick
Floor (≤ x)

arr[mid] ≤ x
      ↓
Store ans
Move Right
(left = mid + 1)

arr[mid] > x
      ↓
Move Left
(right = mid - 1)*/ RIGHT to find a larger element that is still ≤ x.
