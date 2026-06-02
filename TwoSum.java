//step 1  -> get all no one by one 
//step 2 -> no = target - nums[i]
//if no is already there do nothing , if no isnt present there insert in hashmap  ,hashmap store in form of key and value
//store index positions and return 
class TwoSum{
  public int[] twoSum(int [] nums ,int target){
    Map<Integer,Integer> map = new HashMap<>();


  //Step 1 -> traverse array go through all elements of an array
  for (int i=0 ; i<nums.length;i++){

    int no= target - nums[i];    //step 2 -> no =target-nums[i]

    if(map.containsKey(no))      //check if no is present in hashmap
    {
      int index1 = map.get(no);        //if no is present get that in hasmap 
      int index2 = i;                  //also get index of that no

      int[] res = {index1,index2}
        return res;
      
    }
    //if not present in hashmap put it
    map.put(nums[i],i);
  }
    return new int[] {};

  }
}

// Time Complexity: O(n)
// Reason: Traverse array once and HashMap operations (containsKey, put, get) take O(1) average time.

// Space Complexity: O(n)
// Reason: Extra HashMap stores up to n elements (number → index pairs).
    
