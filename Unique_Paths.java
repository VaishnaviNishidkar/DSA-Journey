class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp=new int [m][n];
        return countPaths(m-1,n-1,dp);
        
    }
    int countPaths(int row,int col,int [][] dp){
        if(row==0 || col==0){
            return 1;
        }
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        dp[row][col]=countPaths (row-1,col,dp)+ countPaths(row,col-1,dp);
        return dp[row][col];
    }
}
/*Algorithm:

1. Create a DP array initialized with 0.
2. Start recursion from (m-1, n-1).
3. If result is already in DP:
      Return it.
4. Otherwise:
      paths = top + left
5. Store result in DP.
6. Return DP[row][col].

Time Complexity:
O(m × n)

Reason:
Each cell is computed only once.

Space Complexity:
O(m × n)

Reason:
DP array stores results for all cells.
(Recursive call stack is O(m + n).)

Key Observation:

• Base Case:
      If row == 0 || col == 0
      Return 1.

• First row and first column have only one possible path.

• DP avoids recalculating the same subproblems.
🧠 Memory Trick
Paths(row, col)

        ↑
(row-1, col)

   +
        ←
(row, col-1)

↓

Store in DP

↓

Reuse Later*/
