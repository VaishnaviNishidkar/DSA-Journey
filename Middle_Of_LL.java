//Apptroach -1
### Find Middle of Linked List using Length 📝

class Solution {
    public ListNode middleNode(ListNode head) {

        int length = 0;              // stores length of linked list
        ListNode curr = head;        // start traversal from head

        while(curr != null) {        // traverse until NULL
            length++;                // count current node
            curr = curr.next;        // move to next node
        }

        int middle = length / 2;     // find middle position

        curr = head;                 // start again from head

        for(int i = 0; i < middle; i++) {
            curr = curr.next;        // move to middle node
        }

        return curr;                 // return middle node
    }
}
/*
### Short Revision Notes

**Pattern:** Linked List + Length Calculation

**Idea:**
1. Traverse the whole list and find `length`.
2. Calculate `middle = length / 2`.
3. Start again from `head`.
4. Move `middle` steps.
5. Return `curr`.


1 → 2 → 3 → 4 → 5
        ↑
      middle

length = 5
middle = 5 / 2 = 2
Move 2 steps → Node 3


**Why `length / 2`?**  
Integer division gives the middle index for the **second middle** in an even-sized list.

```text
1 → 2 → 3 → 4
        ↑
     middle = 4/2 = 2 → Node 3
```

**TC:** O(n)  
**SC:** O(1)

🔑 **Memory Trick:**  
**Count length → Find middle → Traverse again → Return middle**
  */
//Optimal approach
  
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode  slow=head;        // slow moves 1 step
        ListNode  fast=head;        // fast moves 2 steps

        while(fast!=null && fast.next!=null){         // continue while fast can move 2 steps
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
/*

### Short Revision Notes

**Pattern:** Two Pointers / Slow & Fast Pointer

**Idea:**

* `slow` moves **1 step**
* `fast` moves **2 steps**
* When `fast` reaches the end, `slow` is at the **middle**

**Example:**

1 → 2 → 3 → 4 → 5
        ↑
       slow


**Why condition?**

java
fast != null && fast.next != null


Because `fast` needs to safely move **2 steps**.

**TC:** O(n)
**SC:** O(1)

🔑 **Memory Trick:**
**Slow = 1 step | Fast = 2 steps → Slow = Middle**
*/
