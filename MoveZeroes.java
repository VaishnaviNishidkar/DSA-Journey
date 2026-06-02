class Solution {
    public void moveZeroes(int[] nums) {
        int nonzeroIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
            nums[nonzeroIndex]=nums[i];
            nonzeroIndex++;
            }
        }
        for(int i=nonzeroIndex;i<nums.length;i++){
            nums[i]=0;
        }
        
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)
