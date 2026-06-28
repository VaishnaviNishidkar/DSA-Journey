class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count =0;
        int prefixSum=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            int rem=prefixSum%k;

            if(rem<0){
               rem+=k;
            }
            if(map.containsKey(rem)){
            count+=map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}
/*Problem:
Subarray Sums Divisible by K (LC 974)

Pattern:
Prefix Sum + HashMap (Remainder Frequency)

Store:

Key   → prefixSum % k
Value → Frequency of remainder

Algorithm:

1. Calculate running sum.
2. Compute remainder.
3. If remainder < 0:
      rem += k
4. If remainder exists:
      count += frequency
5. Increase remainder frequency.

Why map.put(0,1)?

Represents an empty prefix.
Counts subarrays starting from index 0.

Why frequency instead of index?

Every previous occurrence of the same
remainder forms one new valid subarray.

Time Complexity:
O(n)

Space Complexity:
O(k)

Key Observation:

Same remainder ⇒ Subarray sum is divisible by k.

If remainder frequency = f,

New subarrays = f.
*/
