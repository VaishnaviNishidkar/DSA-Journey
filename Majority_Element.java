class Solution {
    public int majorityElement(int[] nums) {

        int majority = nums[0];        // Assume first element is the majority candidate
        int votes = 1;                 // Give the candidate 1 vote

        for (int i = 1; i < nums.length; i++) {  // Traverse from second element

            if (votes == 0) {           // If votes become zero, choose a new candidate
                majority = nums[i];    // Current element becomes new candidate
                votes = 1;              // Give the new candidate 1 vote
            }
            else if (majority == nums[i]) { // If current element matches candidate
                votes++;                // Increase candidate's votes
            }
            else {                      // If current element is different
                votes--;                // Cancel one vote
            }
        }

        return majority;                // Return the majority element
    }
}
