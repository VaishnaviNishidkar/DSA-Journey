//Brute force 

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n= arr.length;
        ArrayList<Integer>  ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            int nextGreater=-1;
            
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    nextGreater=arr[j];
                    break;
                }
            }
            ans.add(nextGreater);
            
        }
        return ans;
    }
    
}

//optimal soln
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {

        int n = arr.length;                     // Store array length

        ArrayList<Integer> ans = new ArrayList<>(); // Store answers

        for (int i = 0; i < n; i++) {
            ans.add(-1);                        // Initially, answer for every element is -1
        }

        Stack<Integer> stack = new Stack<>();   // Stack stores possible next greater elements

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove elements that are smaller than or equal to current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack is not empty, top is the next greater element
            if (!stack.isEmpty()) {
                ans.set(i, stack.peek());
            }

            // Add current element to stack for future elements
            stack.push(arr[i]);
        }

        return ans;                              // Return the result
    }
}

/*Problem:
Next Greater Element

Pattern:
Monotonic Stack

Idea:

• For every element, find the first greater element on its right.
• Traverse from RIGHT → LEFT.
• Use a stack to keep useful greater elements.

Algorithm:

1. Create answer array with -1.
2. Start from the last element.
3. Remove stack elements <= current element.
4. If stack is not empty:
      stack.peek() = Next Greater Element.
5. Push current element into stack.
6. Repeat for all elements.
7. Return answer.

Time Complexity:
O(n)

Reason:
Each element is pushed once and popped at most once.

Space Complexity:
O(n)

Reason:
Stack and answer list can store up to n elements.

Key Observation:

Current element
      ↓
Remove smaller/equal elements
      ↓
Stack top = Next Greater
      ↓
Push current element


MEMORY TRICK
RIGHT → LEFT

while stack.top <= current
        ↓
      POP

stack not empty?
        ↓
   answer = stack.top

        ↓
      PUSH
*/
