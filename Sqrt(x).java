class Solution {
    public int mySqrt(int x) {
        if(x<2) return x;
        long left=1, right =x/2;
        while(left<=right){

            long mid=left+(right-left)/2;
            long square =mid*mid;

            if(square==x)
                return (int) mid;
    
            if(square<x){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
    return (int)right;
        
    }
}
/*Problem:
Sqrt(x) (LC 69)

Pattern:
Binary Search

Idea:

• Search for the integer square root.
• Compare mid² with x.
• If mid² == x:
      Return mid.
• If mid² < x:
      Search right half.
• If mid² > x:
      Search left half.
• If exact square root doesn't exist,
  return right (floor value).

Algorithm:

1. If x < 2:
      Return x.
2. left = 1, right = x / 2
3. While(left <= right):
      mid = left + (right - left) / 2
      square = mid * mid
      If square == x:
            Return mid
      Else if square < x:
            left = mid + 1
      Else:
            right = mid - 1
4. Return right.

Time Complexity:
O(log n)

Reason:
Binary Search halves the search space
in every iteration.

Space Complexity:
O(1)

Reason:
Only constant extra variables are used.

Key Observation:

• If mid² < x → Answer lies on the right.
• If mid² > x → Answer lies on the left.
• When the loop ends,
  right stores the floor value of √x.*/
