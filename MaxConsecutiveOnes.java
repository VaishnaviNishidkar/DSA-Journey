class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
          // Stores length of current consecutive 1's streak
        int current_count=0;
              // Stores maximum streak found so far
        int max_count=0;

        for(int j=0;j<n;j++){
           // If current element is 1, extend the current streak
            if(nums[j]==1){
                current_count++;
            }else{    // If current element is 0,  streak breaks
               // Update maximum streak
                max_count=Math.max(max_count,current_count);
               // Reset current streak
                current_count=0;
            }
        }
       // Handles cases where array ends with 1's
        // Example: [1,1,1]
        return Math.max(current_count,max_count);
        
    }
}
//Time: O(n)
//Space: O(1)
