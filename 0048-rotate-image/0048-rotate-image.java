class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int newMatrix[][] = new int[n][n];

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                newMatrix[j][n-i-1] = matrix[i][j];
            }
        }

        //copy back
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<newMatrix[0].length; j++) {
                matrix[i][j] = newMatrix[i][j];
            }
        }

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}