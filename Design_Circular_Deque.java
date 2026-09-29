class MyCircularDeque {

    int front;                                      // Index of front element
    int rear;                                       // Index of rear element
    int size;                                       // Number of elements
    int capacity;                                   // Maximum capacity
    int deque[];                                    // Array for deque

    public MyCircularDeque(int k) {
        deque = new int[k];                        // Create deque of size k
        front = 0;                                 // Front starts at 0
        rear = k - 1;                              // Rear starts just before index 0
        size = 0;                                  // Initially empty
        capacity = k;                              // Store maximum capacity
    }

    public boolean insertFront(int value) {

        if (isFull()) {                            // Check if deque is full
            return false;                          // Cannot insert
        }

        front = (front - 1 + capacity) % capacity; // Move front backward circularly
        deque[front] = value;                      // Insert value at front
        size++;                                    // Increase number of elements

        return true;                               // Insertion successful
    }

    public boolean insertLast(int value) {

        if (isFull()) {                            // Check if deque is full
            return false;                          // Cannot insert
        }

        rear = (rear + 1) % capacity;             // Move rear forward circularly
        deque[rear] = value;                       // Insert value at rear
        size++;                                    // Increase number of elements

        return true;                               // Insertion successful
    }

    public boolean deleteFront() {

        if (isEmpty()) {                           // Check if deque is empty
            return false;                          // Cannot delete
        }

        front = (front + 1) % capacity;            // Move front forward
        size--;                                    // Decrease number of elements

        return true;                               // Deletion successful
    }

    public boolean deleteLast() {

        if (isEmpty()) {                           // Check if deque is empty
            return false;                          // Cannot delete
        }

        rear = (rear - 1 + capacity) % capacity;  // Move rear backward
        size--;                                    // Decrease number of elements

        return true;                               // Deletion successful
    }

    public int getFront() {

        if (isEmpty()) {                           // Check if deque is empty
            return -1;                             // No front element
        }

        return deque[front];                       // Return front element
    }

    public int getRear() {

        if (isEmpty()) {                           // Check if deque is empty
            return -1;                             // No rear element
        }

        return deque[rear];                        // Return rear element
    }

    public boolean isEmpty() {
        return size == 0;                           // Empty when size is 0
    }

    public boolean isFull() {
        return size == capacity;                   // Full when size equals capacity
    }
}
/*## 📝 Circular Deque, LC 641

**Pattern:** Array + Circular Indexing

**Idea:**
Implement a **double-ended queue (Deque)** where insertion and deletion are possible from both front and rear.

### Main variables

* `front` → index of front element
* `rear` → index of rear element
* `size` → current number of elements
* `capacity` → maximum number of elements
* `deque[]` → array storing elements

### Operations

| Operation     | Logic                    |
| ------------- | ------------------------ |
| `insertFront` | `front--`, then `size++` |
| `insertLast`  | `rear++`, then `size++`  |
| `deleteFront` | `front++`, then `size--` |
| `deleteLast`  | `rear--`, then `size--`  |
| `getFront`    | `deque[front]`           |
| `getRear`     | `deque[rear]`            |
| `isEmpty`     | `size == 0`              |
| `isFull`      | `size == capacity`       |

### 🔄 Circular movement

Forward:

```java
(index + 1) % capacity
```

Backward:

```java
(index - 1 + capacity) % capacity
```

The `+ capacity` prevents a negative index.

### 🧠 Memory Trick

```text
Insert Front → front--
Insert Rear  → rear++
Delete Front → front++
Delete Rear  → rear--
```

**Insert → `size++`**
**Delete → `size--`**

### Complexity

* **Time:** `O(1)` for every operation
* **Space:** `O(k)`

**Key observation:** `% capacity` makes the array circular, so after the last index we come back to index `0`. 🔄
*/
