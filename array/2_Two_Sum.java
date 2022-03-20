// https://leetcode.com/problems/two-sum/

class Solution {

    public int[] twoSum(int[] nums, int target) {
        // Map of diff (target - num) and index
        Map<Integer, Integer> diffs = new HashMap<>(nums.length);
        
        for (int i = 0; i < nums.length; i++) {
            if (diffs.containsKey(nums[i]))
                return new int[] { diffs.get(nums[i]), i };
            
            diffs.put(target - nums[i], i);
        }
        
        return null;
    }

}