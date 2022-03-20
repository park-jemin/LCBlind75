// https://leetcode.com/problems/two-sum/

/*
	Notes: using Map is slightly more performant than object,
	albeit at a slight memory cost, possibly due to hashing

*/ 


/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
 // Using Object
const twoSum = (nums, target) => {
    const diffs = {}
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] in diffs)
            return [diffs[nums[i]], i]
        
        diffs[target - nums[i]] = i
    }
}

// Using Map
const twoSum2 = (nums, target) => {
    const diffs = new Map()
    
    for (let i = 0; i < nums.length; i++) {
        if (diffs.has(nums[i]))
            return [diffs.get(nums[i]), i]
        
        diffs.set(target - nums[i], i)
    }
    
}
