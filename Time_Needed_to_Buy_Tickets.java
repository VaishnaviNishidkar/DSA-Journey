class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;

        for(int c = 0; c < tickets.length; c++) {
            if(c <= k) {
                time += Math.min(tickets[c], tickets[k]);
            } else {
                time += Math.min(tickets[c], tickets[k] - 1);
            }
        }

        return time;
    }
}
/*### 🎟️ Time Needed to Buy Tickets

* **Problem:** Find the time required for person `k` to buy all their tickets.
* **Pattern:** Queue / Simulation
* **Idea:** Every person buys **1 ticket per turn** and moves to the back if they still need tickets.
* For people **before or at `k`** → they can buy up to `tickets[k]` times.
* For people **after `k`** → they can buy up to `tickets[k] - 1` times because the process stops when `k` gets their final ticket.
* **Formula:**

  ```text
  c <= k → min(tickets[c], tickets[k])
  c > k  → min(tickets[c], tickets[k] - 1)
  ```
* **Time:** `O(n)`
* **Space:** `O(1)`
* **Memory Trick:** **Before/at k = full turns | After k = one less turn**
*/
