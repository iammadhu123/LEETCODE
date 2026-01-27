public class SearchIn2DMatrix {
    public static boolean searchMatrix(int matrix[][], int target) { //O(m+n)
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0; int col = n-1;
        while(row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
    // public static boolean searchMatrix(int matrix[][], int target){
    //     int m = matrix.length; //m = number of rows in the matrix // n = number of columns in the matrix
    //     int n = matrix[0].length;

    //     for(int i = 0; i<m; i++){ //O(m*n)
    //         for(int j = 0; j<n; j++){
    //             if (matrix[i][j] == target) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // public static boolean searchMatrix(int matrix[][], int target){//O(n+m)
    //     int row = 0;
    //     int col = matrix[0].length-1;

    //     while (row<matrix.length && col>=0) {
    //         if (matrix[row][col] == target) {
    //             return true;
    //         }else if (matrix[row][col]>target) {
    //             col--; //move left
    //         }else{
    //             row++; //move down
    //         }
    //     }
    //     return false;
    // }
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 60;
        System.out.println(searchMatrix(matrix, target));
    }
}
