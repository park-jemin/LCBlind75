// https://leetcode.com/problems/insert-interval/  

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        
        int start = newInterval[0], end = newInterval[1];
        
        int i = 0;
        // add all intervals up to overlap
        while (i < intervals.length && start > intervals[i][1])
            result.add(intervals[i++]);
        
        // modify start and end until start and end no longer overlap
        while (i < intervals.length && intervals[i][0] <= end) {
            int[] interval = intervals[i++];
            
            if (interval[0] < start)
                start = interval[0];
            
            if (end < interval[1])
                end = interval[1];
        }
        
        // add new combined interval to result
        result.add(new int[] {start, end});
        
        // add remaining intervals to result
        while (i < intervals.length)
            result.add(intervals[i++]);
        
        return result.toArray(int[][]::new);

    }

}