// https://leetcode.com/problems/find-median-from-data-stream/
// 295. Find Median from Data Stream

import java.util.*;

class MedianFinder {
    
    /*
        Have two heaps keep track of lows and highs,
        while adding, ensure balance
        
        Keep maxHeap of lows, minHeap of highs
    */
    
    private Queue<Integer> lows;
    private Queue<Integer> highs;
    private boolean isBalanced;

    public MedianFinder() {
        lows = new PriorityQueue<>(Collections.reverseOrder());
        highs = new PriorityQueue<>();
        isBalanced = true;
    }
    
    public void addNum(int num) {
        // this way alternates balance between lowest and highest
        if (isBalanced) {
            // first add num to lows, then pulls highest low into highs
            lows.offer(num);
            highs.offer(lows.poll());
        } else {
            highs.offer(num);
            lows.offer(highs.poll());
        }
        
        isBalanced ^= true; // flips switch
    }
    
    public double findMedian() {
        if (highs.isEmpty()) // if medianFinder is empty overall
            return 0;
        
        if (isBalanced)
            return (lows.peek() + highs.peek())/2.0; 
        else
            return highs.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */





/*
	Followup:

	1. If all integer numbers from the stream are between 0 and 100,
	how would you optimize it?

	Answer:
	- We can maintain an array length 101 to store counts of numbers [0, 100]
	- using that, and knowing the total numbers added, we can then traverse
		across the array to then find the middle value

	- Time/space complexity = O(101) = O(1)


	To further optimize, we can use a dynamically sizing array based on the values
	passed -- because allocating and copying an array is O(1) based on the max n,
	this would micro-optimize the amount of time needed in best case conditions
*/


class MedianFinder1 {
    
    /*
        Store counts between 0 to 100
    */
    
    private int[] counts;
    private int size;

    public MedianFinder() {
    	counts = new int[101];
    }
    
    public void addNum(int num) {
        ++counts[num];
        ++size;
    }
    
    public double findMedian() {
        int med = 0, i = 0;
        while (med < size/2) {
        	med += counts[i++];
        }
        return i - 1;
    }
}






/*
	Followup:

	2. If 99% all integer numbers from the stream are between 0 and 100,
	how would you optimize it?

	Answer:
	- Same structure as 1, but we store additional sorted lists for 
		numbers < 0 and > 100. 

	- If the distribution of numbers is certain, we do not need to store 
		the order of the additional numbers past a certain point, just their 
		count, as we will 100% guarantee a median between [0, 100].

		At low n, we should store a list and sort it manually, but once
		the distribution becomes established (past 10?), then we will convert
		to the dynamic array

		Time/Space Complexity:
		- Add: O(1), O(1)
		- FindMedian: O(1)

	- If the distribution of numbers is uncertain, probably using min/max 
		heap structures like in initial solution, as these heaps are going 
		to be smaller. At low n, we would poll these and reoffer on an as
		needed basis. 

		In a very uncertain probabilistic environment, if the distribution
		proves to be unpredictable, it would be better to go with our initial 
		solution, storing lows and highs

		Time/Space Complexity:
		- Add: O(logn), O(n)
		- FindMedian: O(1)
	- 

	-
*/


// Assuming certain probability
class MedianFinder1 {
    
    /*
        Store counts between 0 to 100
    */
    
    private int[] counts;
    private int size;

    public MedianFinder() {
    	counts = new int[101];
    }
    
    public void addNum(int num) {
        ++counts[num];
        ++size;
    }
    
    public double findMedian() {
        int med = 0, i = 0;
        while (med < size/2) {
        	med += counts[i++];
        }
        return i - 1;
    }
}

