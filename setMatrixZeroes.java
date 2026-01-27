public class setMatrixZeroes {
    public static void setZeroes(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        // Step 1: Mark rows and columns that should be zero
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if (matrix[i][j] == 0) {
                    rows[i] = true;//entire row
                    cols[j] = true;//entire col
                }
            }
        }

        // Step 2: Set zeros based on marks
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int matrix[][] = {
            {1,1,1},
            {1,0,1},
            {1,1,1},
        };

        setZeroes(matrix);

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
