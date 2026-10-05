public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;       // slow moves 1 step
        ListNode fast = head;       // fast moves 2 steps

        while(fast != null && fast.next != null) {
            slow = slow.next;       // move slow by 1
            fast = fast.next.next;  // move fast by 2

            if(slow == fast) {      // cycle detected
                ListNode newNode = head;

                while(slow != newNode) {
                    slow = slow.next;
                    newNode = newNode.next;
                }

                return newNode;     // cycle starting node
            }
        }

        return null;                // no cycle
    }
}
/*### Detect Cycle II: Find Cycle Starting Node 🔄

**Pattern:** Floyd’s Cycle Detection + Two Pointers

**Idea:**

1. `slow` moves **1 step**, `fast` moves **2 steps**.
2. If `slow == fast` → cycle exists.
3. Reset another pointer to `head`.
4. Move both **1 step at a time**.
5. Where they meet = **cycle starting node**.

```text
slow = head
fast = head
      ↓
slow == fast?
      ↓ YES
one pointer → head
      ↓
both move 1 step
      ↓
meeting point = cycle start
```

**Important:** `fast` must start at `head`, **not `null`**.

**TC:** O(n)
**SC:** O(1)

🔑 **Memory Trick:**
**Meet → Reset → Move together → Meet again = Cycle Start**
*/
