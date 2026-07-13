class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);

    }
    int binarySearch(int[] nums,int left,int right,int target){
        if(left>right){
            return -1;

        }
        int mid=left+(right-left)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]<target){
            return binarySearch(nums,mid+1,right,target);
        }
            return binarySearch(nums,left,mid-1,target);
        
}
}
/*Time Complexity:
O(log n)

Reason:
The search space is halved in every recursive call.

Space Complexity:
O(log n)

Reason:
Recursive call stack stores at most log n calls.

Key Observation:

• Base Case:
      left > right
      Return -1.

• Each recursive call eliminates half of the search space.
🧠 Memory Trick
Find Mid

↓

Target == Mid
      ↓
Return Index

Target > Mid
      ↓
Go Right

Target < Mid
      ↓
Go Left

left > right
      ↓
Not Found (-1)*/
