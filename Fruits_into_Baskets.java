class Solution {
    public int totalFruit(int[] fruits) {
        int left=0;
        int ans=0;
        HashMap<Integer,Integer> map = new HashMap<>();

    for(int r=0;r<fruits.length;r++){
        map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
        while(map.size()>2){
            map.put(fruits[left],map.get(fruits[left])-1);
            if(map.get(fruits[left])==0){
                map.remove(fruits[left]);
            }
            left++;
        }
      ans=Math.max(ans,r-left+1);
    }
      return ans;
    }
}

/*
Problem: Fruit Into Baskets

Approach: Variable Size Sliding Window + HashMap

Idea:
- We can carry only 2 types of fruits.
- Expand the window by moving the right pointer.
- Store frequency of each fruit in a HashMap.
- If more than 2 fruit types are present:
      Shrink the window from the left
      until only 2 types remain.
- Keep track of the maximum window size.

Pattern Used:

- Sliding Window
- Variable Size Window
- HashMap (Frequency Count)

Algorithm:

1. Initialize:
      left = 0
      ans = 0
      HashMap<Integer,Integer> map

2. Traverse using right pointer:
      Add current fruit to map.
      Increase its frequency.

3. While map contains more than 2 fruit types:
      Decrease frequency of fruits[left].
      If frequency becomes 0:
            Remove it from map.
      Move left pointer.

4. Update:
      ans = max(ans, right-left+1)

5. Return ans.

Dry Run Example:

Input:

fruits = [1,2,1,2,3]

Window:

[1]
Types = {1}

Length = 1

----------------

[1,2]
Types = {1,2}

Length = 2

----------------

[1,2,1]

Types = {1,2}

Length = 3

----------------

[1,2,1,2]

Types = {1,2}

Length = 4

----------------

[1,2,1,2,3]

Types = {1,2,3}

Invalid ❌

Shrink window:

Remove 1

Still 3 types

Remove 2

Still 3 types

Remove 1

Now:

Window = [2,3]

Types = {2,3}

Valid ✅

Maximum Length = 4

Output:

4

Time Complexity:

O(n)

Reason:
Each fruit enters and leaves the window at most once.

Space Complexity:

O(1)

Reason:
HashMap stores at most 3 fruit types during execution.
(Generally written as O(1) because the number of fruit types allowed is fixed.)

Key Observation:

Expand window
↓

More than 2 fruit types?

↓

Shrink until only 2 remain

↓

Update maximum window size

Mental Model:

Grow the window as much as possible.

Whenever the basket overflows
(>2 fruit types),

shrink it until it becomes valid again.
*/
