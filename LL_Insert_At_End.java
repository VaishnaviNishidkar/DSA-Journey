/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node insertAtEnd(Node head, int x) {
        // code here
        Node newNode=new Node(x);
        if(head==null){
            return newNode;
            
        }
        Node curr=head;
    
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=newNode;
        
        return head;
    }
}
    /*### 🔗 Insert at End of Linked List

* **Pattern:** Linked List Traversal
* **Idea:** Create a new node and move to the **last node**, then connect the new node.
* If `head == null` → new node becomes the `head`.
* Traverse using `curr` until `curr.next == null`.
* Attach using `curr.next = newNode`.
* Return `head`.

### 🧠 Memory Trick

```text
Create → Check Empty → Traverse to Last → Attach → Return Head
```

### ⏱️ Complexity

* **Time:** `O(n)` because we traverse the list
* **Space:** `O(1)` extra space, excluding the new node

**Key line:**

```java
while(curr.next != null)
    curr = curr.next;
```

This makes `curr` reach the **last node**, where we attach `newNode`.
*/

  //Using recursion
class Solution {
    public Node insertAtEnd(Node head, int x) {
        if(head==null){
            return new Node(x);
        }
        head.next=insertAtEnd(head.next,x);
        return head;
    }
    
    
}
/*### 🔗 Insert at End using Recursion

* **Pattern:** Linked List + Recursion
* **Idea:** Recursively move to the end of the list, then create the new node.
* **Base case:** `head == null` → return `new Node(x)`.
* While returning from recursion, connect the new node using:

  ```java
  head.next = insertAtEnd(head.next, x);
  ```
* Finally return `head`.

### 🧠 Memory Trick

```text
Go till NULL → Create Node → Connect while returning
```

### Example

```text
1 → 2 → 3 → NULL
              ↓
           new Node(4)

1 → 2 → 3 → 4 → NULL
```

### ⏱️ Complexity

* **Time:** `O(n)`
* **Space:** `O(n)` recursion stack

**Key difference:** Iterative version uses `O(1)` extra space, while recursive version uses `O(n)` stack space.
*/
