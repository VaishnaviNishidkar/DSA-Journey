import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each task
        for(char task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        // Store unique tasks
        ArrayList<Character> list = new ArrayList<>(map.keySet());

        // Sort tasks by frequency: highest frequency first
        list.sort((a,b) -> map.get(b) - map.get(a));

        int maxFreq = map.get(list.get(0));

        int gaps = maxFreq - 1;          // Number of gaps
        int emptySlots = gaps * n;       // Total empty positions

        // Fill gaps using remaining tasks
        for(int i = 1; i < list.size(); i++){
            emptySlots -= Math.min(gaps, map.get(list.get(i)));
        }

        int idle = Math.max(0, emptySlots);

        return tasks.length + idle;
    }
}
/*## 📝 Task Scheduler, LC 621

**Pattern:** HashMap + Sorting + Greedy

**Goal:** Schedule tasks so that the same task has at least `n` intervals between two executions.

### 💡 Idea

1. Count frequency of every task using `HashMap`.
2. Store unique tasks in `ArrayList`.
3. Sort tasks by frequency using your familiar logic:

   ```java
   list.sort((a,b) -> map.get(b) - map.get(a));
   ```
4. Use the most frequent task to create gaps.
5. Fill those gaps with other tasks.
6. Remaining gaps become **idle time**.
7. Answer = `total tasks + idle time`.

### Example

```text
tasks = [A,A,A,B,B,B]
n = 2
```

Frequencies:

```text
A → 3
B → 3
```

Create gaps using `A`:

```text
A _ _ A _ _ A
```

Fill with `B`:

```text
A B _ A B _ A B
```

There are **2 idle slots**.

```text
Total tasks = 6
Idle = 2

Answer = 6 + 2 = 8
```

### ⏱️ Complexity

* **Time:** `O(N + M log M)`
* **Space:** `O(M)`

`N` = total tasks, `M` = unique tasks.

### 🧠 Memory Trick

**Count → Sort → Create gaps → Fill → Add idle**

**Key line:**

```java
list.sort((a,b) -> map.get(b) - map.get(a));
```

This means **higher-frequency task comes first**.
*/
