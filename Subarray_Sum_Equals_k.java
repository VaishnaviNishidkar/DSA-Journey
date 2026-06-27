//Brute force code 
class Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;

        for(int i = 0; i < nums.length; i++) {

            int sum = 0;

            for(int j = i; j < nums.length; j++) {

                sum += nums[j];

                if(sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}

//optimal code 
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1);
        int count=0;
        int prefixSum=0;

        for(int n : nums){
            prefixSum+=n;

           
            if(map.containsKey(prefixSum-k)){
                count+=map.get(prefixSum-k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
        
    }
}
/*Approach: Prefix Sum + HashMap

Idea:
- Compute running (prefix) sum while traversing the array.
- At every index, check if there exists a previous prefix sum
  such that:

      prefixSum - previousPrefixSum = k

  Therefore,

      previousPrefixSum = prefixSum - k

- Store frequency of every prefix sum in a HashMap.

Pattern Used:

- Prefix Sum
- HashMap (Frequency Map)

Algorithm:

1. Initialize:
      map.put(0,1)
      prefixSum = 0
      count = 0

2. Traverse array:
      prefixSum += current element

3. If (prefixSum - k) exists in map:
      count += frequency of (prefixSum - k)

4. Store/update current prefix sum frequency.

5. Return count.

Example:

nums = [1,1,1]
k = 2

Prefix Sums:
1, 2, 3

At prefixSum = 2
Need:
2 - 2 = 0
Found in map → count++

At prefixSum = 3
Need:
3 - 2 = 1
Found in map → count++

Answer = 2

Time Complexity:
O(n)

Reason:
Single traversal of array.
HashMap operations are O(1) on average.

Space Complexity:
O(n)

Reason:
HashMap may store up to n different prefix sums.

Key Observation:

If:

prefixSum - previousPrefixSum = k

Then:

previousPrefixSum = prefixSum - k

Store prefix sums, not subarrays.
*/
