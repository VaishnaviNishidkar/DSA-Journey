
 Code: Convert Array to Linked List

class Solution {
    static Node arrayToList(int[] arr) {
        Node head = new Node(arr[0]);
        Node curr = head;

        for(int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }

        return head;
    }
}
```
/*
### Short Revision Notes 📝

**Problem:** Convert an array into a singly linked list.

**Pattern:** Linked List Traversal + Creation

**Idea:**

* First element → create `head`
* `curr` points to the current last node
* Loop through remaining elements
* Create a new node and attach it using `curr.next`
* Move `curr` forward

**Example:**

```text
Array:  [10, 20, 30, 40]

Linked List:
10 → 20 → 30 → 40 → null
```

### Remember this 🔑

```text
Create Head
    ↓
Create New Node
    ↓
Attach using curr.next
    ↓
Move curr
    ↓
Return head
```

**Time:** O(n)
**Space:** O(n) for the newly created linked-list nodes.
*/
