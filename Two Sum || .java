class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;
        int left=0;
        int right=n-1;

        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum==target){
                return new int [] {left+1,right+1};
            }else if(sum>target){
                right--;
            }else{
                left++;
            }

          }
          return new int []{-1,-1};
        
    }
}
//to watch vdo -> https://www.youtube.com/watch?v=o_fANlVBKuU&list=PLvNVexrplJJzvtkPJ6tTZGqbwd5NlJBF2
/*Problem:
Two Sum II (Sorted Array)

Pattern:
Two Pointers

Why It Works:
Array is sorted.

If sum > target:
    move right pointer left

If sum < target:
    move left pointer right

Time Complexity:
O(n)

Reason:
Each pointer moves at most n times.

Space Complexity:
O(1)

Reason:
Only constant extra variables used.

When To Use:
- Sorted Array
- Pair Sum Problems
- Target Sum Questions*/
