
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
            return true;
            }
        }
        return false;
        }
    
    }
/*### Linked List Cycle Detection 🔄

**Pattern:** Two Pointers / Floyd’s Cycle Detection

**Idea:**
Use two pointers:

* `slow` moves **1 step**
* `fast` moves **2 steps**
* If there is a cycle, they will eventually **meet**.
* If `fast` reaches `null`, there is **no cycle**.

### Short Revision Notes


slow → 1 step
fast → 2 steps

If slow == fast → Cycle exists ✅
If fast == null → No cycle ❌

`slow` and `fast` keep moving inside the cycle and eventually meet.

**Why `fast != null && fast.next != null`?**
Because `fast` moves two nodes at a time, so we must check both before doing:

```java
fast = fast.next.next;
```

**TC:** O(n)
**SC:** O(1)

🔑 **Memory Trick:**
**Slow 1 + Fast 2 → Meet = Cycle**
*/
