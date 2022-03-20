// https://leetcode.com/problems/set-matrix-zeroes/
// 73. Set Matrix Zeroes

class Solution {
    public void setZeroes(int[][] matrix) {
        // O(mn) time, O(n + m) space solution
        
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroCols = new boolean[matrix[0].length];
        
        for (int row = 0; row < matrix.length; row++) {            
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    zeroRows[row] = true;
                    zeroCols[col] = true;
                }
            }
        }
        
        for (int row = 0; row < zeroRows.length; row++) {
            if (!zeroRows[row])
                continue;
            
            for (int col = 0; col < zeroCols.length; col++)
                matrix[row][col] = 0;
        }
        
        for (int col = 0; col < zeroCols.length; col++) {
            if (!zeroCols[col])
                continue;
            
            for (int row = 0; row < matrix.length; row++)
                matrix[row][col] = 0;
        }
        
    }
    
}