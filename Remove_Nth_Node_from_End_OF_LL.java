//Brute force
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length=0;
         ListNode curr=head;
        while(curr!=null){
            length++;
            curr=curr.next;
        }
        int pos=length-n;
        if(pos==0){
            return head.next;

        }
        curr=head;
        for(int i=1;i<pos;i++)
            curr=curr.next;
            curr.next = curr.next.next;
             return head;
    }
}
/*### 🔗 Remove Nth Node From End

- **Pattern:** Linked List + Length Calculation
- **Idea:** First find the **length** of the linked list, then calculate the position from the beginning.
- `pos = length - n`
- If `pos == 0` → the **head** is the node to delete, so return `head.next`.
- Otherwise, move `curr` to the node **before** the target.
- Delete target using:
  ```java
  curr.next = curr.next.next;
  ```

### 🧠 Memory Trick

```text
Find Length → Find Position → Reach Previous Node → Skip Target
```

### Example


1 → 2 → 3 → 4 → 5
            ↑
           n=2


`length = 5`


pos = 5 - 2 = 3
```

Delete node `4`:

3.next = 4.next

1 → 2 → 3 ─────→ 5
```

### ⏱️ Complexity

- **Time:** `O(n)`  
  Two traversals, but still O(n).
- **Space:** `O(1)`

**Key line:**

```java
curr.next = curr.next.next;
```

It **skips the node we want to remove**.*/
