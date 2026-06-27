class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res = new int[n];
        res[0]=1;
        
        for(int i=1;i<n;i++){
            res[i]= res[i-1]*nums[i-1];
        }

        int rightProd=1;
        for(int r=n-1;r>=0;r--){
            res[r]=res[r]*rightProd;
            rightProd*=nums[r];
        }
         return res; 
    }
  
}
/*
Problem: Product of Array Except Self

Approach: Prefix Product + Suffix Product

Idea:
- First pass:
    Store product of all elements to the LEFT of each index.
- Second pass:
    Traverse from right and multiply each index
    with the product of all elements to the RIGHT.

Pattern Used:

- Prefix Product
- Suffix Product

Algorithm:

1. res[0] = 1
2. Build left products.
3. rightProd = 1
4. Traverse from right:
      res[i] *= rightProd
      rightProd *= nums[i]
5. Return res.

Time Complexity:
O(n)

Space Complexity:
O(1)
(Excluding output array)

Key Observation:

Answer[i]

=

Left Product × Right Product
*/
