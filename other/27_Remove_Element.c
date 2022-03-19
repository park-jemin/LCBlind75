// https://leetcode.com/problems/remove-element/
// 27. Remove Element

// Must be in place and with O(1) extra memory
int removeElement(int* nums, int numsSize, int val){

	// Have two pointers for back and front
    int last = numsSize - 1;
    int k = 0;
    
    while (k <= last) {

        if (nums[k] == val) {

        	// Loop over last pointer until we reach
        	// a non val value
            while (last > k && nums[last] == val)
                --last;
            
            // Instead of swapping with last, can just
            // replace. Since i (the number of elements
            // not equal to val), will be incremented 
            // separately, can be done here before checking
            nums[k] = nums[last--];

        } else ++k; 
    }
    
    return i;
}