import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> sumCountMap = new HashMap<>();

        sumCountMap.put(0, 1);                  // Prefix sum 0 occurs once

        int result = 0;                        // Store number of valid subarrays
        int prefixSum = 0;                    // Store current prefix sum

        for (int num : nums) {

            prefixSum += num;                 // Add current number

            if (sumCountMap.containsKey(prefixSum - k)) {
                result += sumCountMap.get(prefixSum - k); // Add matching prefix count
            }

            sumCountMap.put(
                prefixSum,
                sumCountMap.getOrDefault(prefixSum, 0) + 1
            );                                // Store/update prefix sum frequency
        }

        return result;                        // Return total count
    }
}
/*Done 👍 We'll keep the **YouTube version** as your version for revision.

# Count Subarrays with Sum K

### 💻 Code

```java
import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> sumCountMap = new HashMap<>();

        sumCountMap.put(0, 1);                  // Prefix sum 0 occurs once

        int result = 0;                        // Store number of valid subarrays
        int prefixSum = 0;                    // Store current prefix sum

        for (int num : nums) {

            prefixSum += num;                 // Add current number

            if (sumCountMap.containsKey(prefixSum - k)) {
                result += sumCountMap.get(prefixSum - k); // Add matching prefix count
            }

            sumCountMap.put(
                prefixSum,
                sumCountMap.getOrDefault(prefixSum, 0) + 1
            );                                // Store/update prefix sum frequency
        }

        return result;                        // Return total count
    }
}
```

---

# 🎬 Understand with Example

Take:

```text
nums = [1, 2, 3, 4]
k = 3
```

We maintain:

```text
prefixSum = current sum
result    = number of subarrays found
map       = prefixSum → frequency
```

Initially:

```text
map = {0 : 1}
prefixSum = 0
result = 0
```

### Step 1: num = 1

```text
prefixSum = 0 + 1 = 1
```

Check:

```text
prefixSum - k
= 1 - 3
= -2
```

`-2` isn't in map ❌

Store:

```text
map = {0:1, 1:1}
```

---

### Step 2: num = 2

```text
prefixSum = 1 + 2 = 3
```

Check:

```text
prefixSum - k
= 3 - 3
= 0
```

`0` exists in map ✅

```text
result += map.get(0)
result = 1
```

The subarray is:

```text
[1, 2] → 3
```

Store `3`:

```text
map = {0:1, 1:1, 3:1}
```

---

### Step 3: num = 3

```text
prefixSum = 3 + 3 = 6
```

Check:

```text
6 - 3 = 3
```

`3` exists ✅

```text
result = 1 + 1 = 2
```

Subarray:

```text
[3] → 3
```

Store:

```text
map = {0:1, 1:1, 3:1, 6:1}
```

---

### Step 4: num = 4

```text
prefixSum = 6 + 4 = 10
```

Check:

```text
10 - 3 = 7
```

`7` doesn't exist ❌

Store:

```text
map = {0:1, 1:1, 3:1, 6:1, 10:1}
```

### 🎯 Final answer

```text
result = 2
```

Valid subarrays:

```text
[1, 2] → 3
[3]    → 3
```

---

# 📝 Short Notes

**Problem:** Count subarrays whose sum equals `k`.

**Pattern:** Prefix Sum + HashMap

**Idea:** Store previous prefix sums and their frequencies.

If:

```text
current prefixSum - previous prefixSum = k
```

then:

```text
previous prefixSum = prefixSum - k
```

So we check:

```java
sumCountMap.containsKey(prefixSum - k)
```

and add its frequency.

### Why `map.put(0,1)`?

It handles subarrays that start from index `0`.

Example:

```text
[1,2], k=3
```

When `prefixSum = 3`:

```text
3 - 3 = 0
```

So the initial `0 → 1` allows `[1,2]` to be counted.

### Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

### 🧠 Memory Trick

**Add → Check `prefixSum-k` → Count → Store**

Or even shorter:

> **Current sum − needed sum = previous sum** 🔑*/
