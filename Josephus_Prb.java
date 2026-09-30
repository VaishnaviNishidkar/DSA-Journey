class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> list= new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);

        }
        int index=0;
        while(list.size()>1){
            index=(index + (k-1))% list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
/*📌 Short GitHub Notes

Problem: Find the winner in Josephus elimination game.

Pattern: ArrayList + Circular Simulation

Idea: Start from index 0. Count k people, remove the kth person, and continue from the next person.

Key Formula:

index = (index + k - 1) % list.size();

Why k - 1? Current index is already counted as 1.

Why % size? To wrap around when reaching the end.

TC: O(n²) because ArrayList.remove(index) can take O(n).

SC: O(n)

Memory Trick:
Count → Find index → Remove → Continue → Last person wins*/
