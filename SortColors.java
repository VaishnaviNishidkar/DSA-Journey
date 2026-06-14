class Solution {
    public void sortColors(int[] nums) {
    int n=nums.length;

        int start =0, mid=0;
        int end=n-1;
        while(mid<=end){
            switch(nums[mid]){
                case 0:
                //swap with start index 
                swap(nums,start,mid);
                mid++;
                start++;
                break;

                case 1:
                      mid++;
                      break;

                case 2:
                //swap mid and end
                      swap(nums,end,mid);
                      end--; 
                      break;
            }
        }
    }
    private void swap(int[] nums, int pos1, int pos2){

        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
}
}

//case 0 - swap with element of start pointer, start++, mid++
//case 1 - no swapping , mid++
//case 2 - swap with end pointer , end--

/*Utility Operation: Swap

Used in:
- Sort Colors
- Selection Sort
- Quick Sort
- Two Pointer Problems*/

//Time Complexity: O(1)
//Space Complexity: O(1)
