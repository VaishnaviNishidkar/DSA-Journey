import java.util.*;

class Solution {
    public String frequencySort(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){                    // Traverse all characters
            char ch = s.charAt(i);                          // Get current character
            map.put(ch, map.getOrDefault(ch,0) + 1);        // Increase frequency
        }

        ArrayList<Character> list = new ArrayList<>(map.keySet()); // Store unique characters

        list.sort((a,b) -> map.get(b) - map.get(a));        // Sort by frequency descending

        StringBuilder ans = new StringBuilder();

        for(char ch : list){                               // Traverse sorted characters
            for(int i=0; i<map.get(ch); i++){              // Repeat according to frequency
                ans.append(ch);                            // Add character
            }
        }

        return ans.toString();
    }
}
/*
📝 Short Notes

Problem: Sort characters according to their frequency.

Pattern: HashMap + Sorting

Idea:
Count each character → sort characters by frequency → repeat each character according to its frequency.

Steps:

Store character frequencies in HashMap.
Put unique characters into ArrayList.
Sort list by frequency in descending order.
Add each character to StringBuilder according to its frequency.

TC: O(n + m log m)
SC: O(m)
n = length of string, m = number of unique characters.

Key Observation:
map.get(ch) tells us how many times ch occurs.

Memory Trick:
👉 Count → Sort → Repeat*/
