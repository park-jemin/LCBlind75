// https://leetcode.com/problems/contains-duplicate/

/**
 * @param {number[]} nums
 * @return {boolean}
 */
const containsDuplicate = nums =>  (new Set(nums)).size < nums.length
