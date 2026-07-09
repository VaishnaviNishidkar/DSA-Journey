class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top =0;
        int bottom=m-1;
        int row=-1;

        while(top<=bottom){
            int mid=(top+bottom)/2;

            if(target>=matrix[mid][0]&&target<=matrix[mid][n-1]){
                row=mid;
                break;

            }else if(target<matrix[mid][0]){
                bottom=mid-1;
            
            }else{
                top=mid+1;
            }

        }
    if(row==-1) return false;

    int left=0;
    int right=n-1;

    while(left<=right){
        int mid=(left+right)/2;
        if(matrix[row][mid]==target){
            return true;
        }else if (matrix[row][mid]<target){
            left=mid+1;

        }else{
            right=mid-1;
        }
    }
    return false;
    }
}
/*Problem:
Search a 2D Matrix (LC 74)

Pattern:
Binary Search

Idea:

• First Binary Search:
      Find the row where the target can exist.

• Second Binary Search:
      Search the target in that row.

Algorithm:

1. Binary Search on rows.
2. If row not found → Return false.
3. Binary Search on columns of that row.
4. Return true if found, else false.

Time Complexity:
O(log m + log n)

Reason:
One Binary Search on rows and one on columns.

Space Complexity:
O(1)

Reason:
Only constant extra variables are used.

Key Observation:

• Each row is sorted.
• First element of every row is greater than the last element of the previous row.


  MEMORY TRICK 
  Step 1:
Find the Correct Row
(Row Binary Search)

↓

Step 2:
Find the Target
(Column Binary Search)

↓

Return true / false*/
