class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>(); // Store frequency

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); // Count frequency
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet()); // Store unique numbers

        list.sort((a, b) -> map.get(b) - map.get(a)); // Sort by frequency descending

        int[] ans = new int[k]; // Store answer

        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i); // Take top k frequent elements
        }

        return ans;
    }
  
}
//### LC 347: Top K Frequent Elements

/** **Pattern:** HashMap + Sorting
* **Idea:** Count frequency of each element using HashMap, then sort elements by frequency.
* **Steps:**

  1. HashMap → store `number → frequency`
  2. Put unique numbers into ArrayList
  3. Sort ArrayList by frequency descending
  4. Take first `k` elements
* **TC:** `O(n + m log m)` where `m` = unique elements
* **SC:** `O(m)`
* **Key Observation:** HashMap gives frequency, sorting helps find top `k`.
* **Memory Trick:** **Count → Sort → Take K** 🔑*/
