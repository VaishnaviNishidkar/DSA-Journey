class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int n=nums.length;

        Arrays.sort(nums);
        
     for(int i=0;i<n-2;i++){
        if(i>0 &&nums[i]==nums[i-1]) continue;
                int l=i+1,r=n-1;
    

    while(l<r){
        int sum=nums[i]+nums[j]+nums[k];

        if(sum==0){
            res.add(Arrays.asList(nums[i],nums[l],nums[r]));
            while(l<r &&nums[l]==nums[l+1]); l++;
            while( l<r &&nums[r]==nums[r-1]); r--;

        }else if (sum>0){
            r--
        }else{
            l++;
        }

     
     
     }
     }
       return  res;  
    }
   
}
/*Problem:
3Sum (LC 15)

Pattern:
Sorting + Two Pointers

Idea:

• Sort the array first.
• Fix one element (i).
• Use two pointers:
      l = i + 1
      r = n - 1
• Find three numbers whose sum is 0.
• Skip duplicate elements to avoid repeated triplets.

Algorithm:

1. Sort the array.
2. Traverse i from 0 to n-3.
3. Skip duplicate values of i.
4. Set:
      l = i + 1
      r = n - 1
5. While(l < r):
      sum = nums[i] + nums[l] + nums[r]

      If sum == 0:
            Store triplet.
            Skip duplicate values of l and r.
            l++
            r--

      If sum < 0:
            l++

      If sum > 0:
            r--

6. Return all unique triplets.

Time Complexity:
O(n²)

Reason:
Sorting takes O(n log n).
Outer loop runs O(n).
Two pointers together take O(n).

Overall:
O(n²)

Space Complexity:
O(1)

Reason:
Ignoring the output list,
only constant extra space is used.

Key Observation:

• Sorting makes duplicate removal easy.
• Fix one element.
• Solve the remaining Two Sum using two pointers.
• Skip duplicates after finding a valid triplet.*/
