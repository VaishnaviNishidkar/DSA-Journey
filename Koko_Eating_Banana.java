class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;         // Maximum possible eating speed
        int high = 0;       // Maximum possible eating speed

        // Find the largest pile (maximum possible speed)
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
      
        int ans = high;      // Stores the minimum valid eating speed

        // Binary Search on eating speed
        while (low <= high) {
  
            int mid = low + (high - low) / 2;         // Middle eating speed
          
            if (canEat(piles, h, mid)) {            // Check if Koko can finish all bananas at speed = mid
                ans = mid;
                high = mid - 1;                    // Try to find a smaller valid speed
            } else {
                low = mid + 1;                    // Speed is too slow, increase it
            }
        }

        // Return the minimum eating speed
        return ans;
    }

    // Returns true if Koko can finish within h hours
    private boolean canEat(int[] piles, int h, int k) {

        // Total hours required
        int hours = 0;

        // Calculate hours for each pile
        for (int pile : piles) {

            // Ceiling of (pile / k)
            hours += (pile + k - 1) / k;
        }

        // Can finish within h hours?
        return hours <= h;
    }
}
/*Problem:
Koko Eating Bananas (LC 875)

Pattern:
Binary Search on Answer

Idea:

• Eating speed lies between:
      1 and Maximum pile.
• Binary Search on speed.
• If Koko can finish in h hours:
      Store answer.
      Try a smaller speed.
• Otherwise:
      Increase the speed.

Algorithm:

1. low = 1
2. high = Maximum pile
3. Binary Search on speed.
4. Calculate total hours needed.
5. Return minimum valid speed.

Time Complexity:
O(n × log(maxPile))

Reason:
For each Binary Search step, traverse all piles once.

Space Complexity:
O(1)

Reason:
Only constant extra variables are used.

Key Observation:

• Smaller speed → More hours.
• Larger speed → Fewer hours.
• Binary Search finds the minimum valid speed.
  
  🧠 Memory Trick
Speed Too Slow
(hours > h)
      ↓
Increase Speed
(low = mid + 1)

--------------------

Speed Works
(hours ≤ h)
      ↓
Store Answer
Try Smaller Speed
(high = mid - 1)*/
