class Solution {
    public void moveZeroes(int[] nums) {
        int left =0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=0){
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
                left++;
            }
        }
    }
}

//to watch this vdo -> https://www.youtube.com/watch?v=kxibKXHbgVs&list=PLvNVexrplJJzvtkPJ6tTZGqbwd5NlJBF2&index=5
//Time Complexity: O(n)
//Space Complexity: O(1)






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
