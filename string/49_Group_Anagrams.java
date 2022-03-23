// https://leetcode.com/problems/group-anagrams/
// 49 Group Anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // O(n), where n is number of strings
        Map<String, List<String>> anagrams = new HashMap<>(strs.length);
        
        for (String word : strs) {
        	// O(m log m), where m is the number of characters
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = String.valueOf(chars);
            
            
            if (!anagrams.containsKey(sortedWord))
                anagrams.put(sortedWord, new LinkedList<>());
            
            anagrams.get(sortedWord).add(word);
        }
        
        return new ArrayList<>(anagrams.values());
        
    }
}