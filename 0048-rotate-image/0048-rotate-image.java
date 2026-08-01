class Solution {
    public void rotate(int[][] matrix) {
        //Phase 1 => Transpose of the matrix
        int n = matrix.length;
        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n; j++) {
                //swap diagonally
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Phase 2 => reverse row
        for(int i = 0; i<n; i++) {
            int start = 0; 
            int end = n-1;
            while (start<end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++; end--;
            }
        }
    }
}



