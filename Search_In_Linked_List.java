//Using iterative approach
/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public boolean searchKey(Node head, int key) {
        // Code here
        Node curr=head;
        while(curr!=null){
            if(curr.data==key){
                return true;
            }
            curr=curr.next;
        }
        return false;
    }
}
/*✨ Memory Trick

Check → Move → Repeat

curr.data == key → Check
curr = curr.next → Move

⏱️ Complexity
Time: O(n) worst case
Space: O(1)

Example:
10 → 20 → 30 → 40, key = 30

10 ❌ → 20 ❌ → 30 ✅ → true*/

//Using recursion
class Solution {
    public boolean searchKey(Node head, int key) {
        // Code here
    if(head==null){
    return false;
    
    }if(head.data==key){
        return true;
        }
        return searchKey(head.next,key);
    }
}
