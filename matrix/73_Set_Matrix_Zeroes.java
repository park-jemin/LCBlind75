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


class Solution2 {
    public void setZeroes(int[][] matrix) {
        // O(mn) time, O(1) space solution
        /*
            Idea: use first cell of every row/col
            as a flag to determine which rows/cols 
            to flip. Have two separate markers to 
            determine if the first row/col should be
            zeroed.
        */
        
        boolean firstRowIsZero = false,
                firstColIsZero = false;
        
        // 1. Iterate over matrix, flagging zeroes and 
        // marking rows/columns
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    if (row == 0)
                        firstRowIsZero = true;
                    else
                        matrix[row][0] = 0; // flag first col
                        
                    if (col == 0)
                        firstColIsZero = true;
                    else
                        matrix[0][col] = 0; // flag first row
                    
                }
            }
        }
        
        // 2. Iterate over matrix again, flipping zeroes if 
        // flagged at beginning 
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0)
                    matrix[row][col] = 0;
            }
        }
        
        // 3. Flip first row / col, if flagged
        if (firstRowIsZero) {
            Arrays.fill(matrix[0], 0);
            // for (int col = 0; col < matrix[0].length; col++)
            //     matrix[0][col] = 0;
        }
        
        if (firstColIsZero) {
            for (int row = 0; row < matrix.length; row++)
                matrix[row][0] = 0;
        }
    }
    
}