import java.util.*;

class myQueue {

    private Stack<Integer> input;
    private Stack<Integer> output;

    // Constructor
    public myQueue(int n) {
        input = new Stack<>();
        output = new Stack<>();
    }

    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }

    public boolean isFull() {
        return false;   // Stack-based queue has no fixed size
    }

    public void enqueue(int x) {
        input.push(x);
    }

    public void dequeue() {
        if (isEmpty()) return;

        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        output.pop();
    }

    public int getFront() {
        if (isEmpty()) return -1;

        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public int getRear() {
        if (isEmpty()) return -1;

        if (!input.isEmpty()) {
            return input.peek();
        }

        // If input is empty, move elements back
        while (!output.isEmpty()) {
            input.push(output.pop());
        }

        return input.peek();
    }
}
/*🧠 Main idea
ENQUEUE → input.push()

DEQUEUE → if output empty:
             input → output
          then output.pop()

FRONT   → output.peek()

REAR    → input.peek()

Example:

enqueue(10)
enqueue(20)
enqueue(30)

input:
[30] ← top
[20]
[10]

Transfer to output:

output:
[10] ← top
[20]
[30]

dequeue() → 10

This works because two stacks reverse the order, giving us FIFO behavior from LIFO stacks.


For **Queue using Two Stacks**:

| Operation    |    Time Complexity |
| ------------ | -----------------: |
| `enqueue()`  |           **O(1)** |
| `dequeue()`  | **O(1) amortized** |
| `getFront()` | **O(1) amortized** |
| `getRear()`  | **O(1) amortized** |
| `isEmpty()`  |           **O(1)** |

### Overall

* **Time:** **O(1) amortized** per operation
* **Space:** **O(n)**

Why `dequeue()` is amortized O(1): elements may be transferred from `input` to `output` in **O(n)** once, but each element is transferred only once.
*/
