class MyCircularQueue {
int [] arr;
int count;
int maxSize;
int head;
    public MyCircularQueue(int k) {
        arr=new int [k];
        count=0;
        maxSize=k;
        head=0;

    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;

        }
        arr[(head+count)%maxSize]=value;
        count=count+1;
        return true;
    }
    
    public boolean deQueue() {
         if(isEmpty()){
        return false;
    }
     head=(head+1)%maxSize;
    count=count-1;
    return true;
    }
   
   
    
    public int Front() {
        if(isEmpty()){
        return -1;
    }
    return arr[head];

    }
    
    public int Rear() {
        if(isEmpty()){
        return -1;
    }
return arr[(head + count - 1) % maxSize];    }
    
    public boolean isEmpty() {
  return count==0;      
    }
    
    public boolean isFull() {
        return count==maxSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();

*/

/*Yes bro, **this code is correct** for LeetCode 622, *Design Circular Queue*. ✅
Your implementation uses the **array + `head` + `count` approach**, which is clean and easy to revise.

## ✅ Final Code with comments on every line

```java
class MyCircularQueue {

    int[] arr;                                      // Store queue elements
    int count;                                      // Number of elements currently in queue
    int maxSize;                                    // Maximum capacity of queue
    int head;                                       // Index of front element

    public MyCircularQueue(int k) {
        arr = new int[k];                           // Create array of size k
        count = 0;                                  // Initially queue is empty
        maxSize = k;                                // Store maximum queue size
        head = 0;                                   // Front starts at index 0
    }

    public boolean enQueue(int value) {

        if (isFull()) {                             // Check if queue is full
            return false;                           // Cannot insert
        }

        arr[(head + count) % maxSize] = value;     // Find rear position and insert value
        count = count + 1;                          // Increase number of elements

        return true;                                // Insertion successful
    }

    public boolean deQueue() {

        if (isEmpty()) {                            // Check if queue is empty
            return false;                           // Cannot delete
        }

        head = (head + 1) % maxSize;               // Move front to next position
        count = count - 1;                          // Decrease number of elements

        return true;                                // Deletion successful
    }

    public int Front() {

        if (isEmpty()) {                            // Check if queue is empty
            return -1;                              // No front element
        }

        return arr[head];                           // Return front element
    }

    public int Rear() {

        if (isEmpty()) {                            // Check if queue is empty
            return -1;                              // No rear element
        }

        return arr[(head + count - 1) % maxSize];  // Calculate and return rear element
    }

    public boolean isEmpty() {
        return count == 0;                          // Queue is empty when count is 0
    }

    public boolean isFull() {
        return count == maxSize;                    // Queue is full when count equals capacity
    }
}
```

---

# 📝 GitHub Short Notes

### Circular Queue

**Problem:** Implement a queue using a fixed-size circular array.

**Pattern:** Array + Circular Indexing

### 💡 Idea

Use:

* `head` → points to **front**
* `count` → number of elements
* `maxSize` → capacity

Use `% maxSize` to make the index **wrap around**.

### Operations

**Enqueue:**

```java
(head + count) % maxSize
```

Find next position after the current elements.

**Dequeue:**

```java
head = (head + 1) % maxSize;
```

Move front forward.

**Front:**

```java
arr[head]
```

**Rear:**

```java
arr[(head + count - 1) % maxSize]
```

**Empty:**

```java
count == 0
```

**Full:**

```java
count == maxSize
```

### Complexity

| Operation   | Time | Space |
| ----------- | ---: | ----: |
| `enQueue()` | O(1) |  O(1) |
| `deQueue()` | O(1) |  O(1) |
| `Front()`   | O(1) |  O(1) |
| `Rear()`    | O(1) |  O(1) |
| `isEmpty()` | O(1) |  O(1) |
| `isFull()`  | O(1) |  O(1) |

**Overall Space:** `O(k)`

### 🧠 Memory Trick

**Head = Front**
**Count = How many**
**`% maxSize` = Circular movement** 🔄

Most important formulas:

```text
Enqueue → (head + count) % maxSize
Dequeue → (head + 1) % maxSize
Rear    → (head + count - 1) % maxSize
```

For your GitHub revision notes, the one-line idea is:

> **Circular Queue = Array + Head + Count + Modulo (`%`)**.
*/
