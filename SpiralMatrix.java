import java.util.*;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; int n = matrix[0].length;
        int left = 0; int top = 0; int bottom = m-1; int right = n-1;
        List<Integer> result  = new java.util.ArrayList<>();
        
        //right
        while (top <= bottom && left <= right) {
            //left to right
            for(int j = left; j <= right; j++){
                result.add(matrix[top][j]);
            }
            top++;

            //top to bottom
            for(int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            //right to left
            if (top <= bottom) {
                for(int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
            }
            // for(int j = right; j >= left; j--) {
            //     if (top == bottom) {
            //         break;
            //     }
            //     result.add(matrix[bottom][j]);
            // }
            bottom--;

            // bottom to top
            if(left <= right){
                for(int i =  bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            // for(int i =  bottom; i >= top; i--) {
            //     if (left == right) {
            //         break;
            //     }
            //     result.add(matrix[i][left]);
            // }
            left++;
        }
    
        return result;
    } 
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 10},
            {4, 5, 6, 15},
            {7, 8, 9, 16},
            {11,12,13,14}
        };

        // List<Integer> spiral = spiralOrder(matrix);
        // System.out.println(spiral);  //OR
        System.out.println(spiralOrder(matrix));
    }
}
