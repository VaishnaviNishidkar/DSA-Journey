class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            if(map.containsKey(sum%k)){
                //check size
                int index=map.get(sum%k);
                if(i-index>=2){
                    return true;
                }
            }else{
                map.put(sum%k,i);
            }

        }
        return false;
        
    }
}
/*
Problem: Continuous Subarray Sum (LeetCode 523)

Approach: Prefix Sum + HashMap (Remainder Method)

Idea:
- Calculate the running (prefix) sum while traversing the array.
- Compute the remainder of the prefix sum with k.
- If the same remainder appears again, the subarray
  between the previous index and current index has
  a sum divisible by k.
- The subarray must contain at least 2 elements.

Pattern Used:

- Prefix Sum
- HashMap (Remainder → First Index)

Algorithm:

1. Create a HashMap:
      remainder -> first index

2. Initialize:
      map.put(0, -1)
      (Represents an empty prefix before index 0)

3. Traverse the array:
      sum += nums[i]

4. Compute:
      remainder = sum % k

5. If remainder already exists:
      index = map.get(remainder)

      If (i - index >= 2)
            return true

6. Otherwise:
      Store:
      remainder -> i

7. Return false if no valid subarray exists.

Pattern Used:

- Prefix Sum
- HashMap

Dry Run Example:

Input:

nums = [23,2,4,6,7]
k = 6

Initial:

map = {0 = -1}
sum = 0

--------------------------------

i = 0

sum = 23

remainder = 5

Store:
5 -> 0

--------------------------------

i = 1

sum = 25

remainder = 1

Store:
1 -> 1

--------------------------------

i = 2

sum = 29

remainder = 5

Already exists

index = 0

Length = i - index
       = 2 - 0
       = 2

Return true

Time Complexity:

O(n)

Reason:
Single traversal of the array.
HashMap operations take O(1) on average.

Space Complexity:

O(min(n, k))

Reason:
HashMap stores unique remainders.
Maximum possible remainders are from 0 to k-1.

Key Observation:

If the remainder at index 'i'
is equal to the remainder stored at 'index',

then the sum of elements between
(index + 1) and i

is divisible by k.

Why map.put(0,-1)?

Represents an empty prefix before the array starts.

Helps detect subarrays beginning from index 0.

Why store only the first occurrence?

Keeping the earliest index gives the maximum
possible subarray length.

This helps satisfy:

i - index >= 2

Mental Model:

Running Sum
      ↓
Take remainder (sum % k)
      ↓
Seen this remainder before?
      ↓
Yes
      ↓
Get previous index
      ↓
Check:
i - index >= 2 ?
      ↓
Yes → Return true

No
      ↓
Store (remainder, i)
Continue
*/
