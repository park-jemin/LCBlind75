// https://leetcode.com/problems/number-of-1-bits/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n); // this is cheating
    }
}

// Followup: if the function is called many times, might prefer to use a cache