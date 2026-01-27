import java.util.Arrays;

// class MissingAndRepeated {
//     public static int[] findMissingAndRepeatedValues(int[][] grid) {
//         int n = grid.length;
//         int total= n*n;
//         int idx = 0;

//         int arr[] = new int[total];
//         for(int i = 0; i<n; i++){//1: Convert 2-D grid → 1-D array
//             for(int j = 0; j<n; j++){
//                 arr[idx++] = grid[i][j];
//             }
//         }
//         //2.Use hash arr like 1D 
//         int hash[] = new int[total+1];
//         for(int i = 0; i<total; i++){
//             hash[arr[i]]++;
//         }

//         int missing = -1, repeated = -1;
//         for(int i = 1; i<=total; i++){
//             if (hash[i] == 0 && missing == -1) {
//                 missing= i;
//             }else if (hash[i] == 2 && repeated == -1) {
//                 repeated = i;
//             }

//             if (missing != -1 && repeated != -1) {
//                 break;
//             }
//         }

//         return new int[]{repeated,missing};
//     }
//     public static void main(String[] args) {
//         int[][] grid = {
//             {1, 2, 2},
//             {3, 4, 4},
//             {5, 6, 6}
//         };
//         System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
//     }
// }

// missing == -1 → means “I haven’t set missing yet”

// repeated == -1 → means “I haven’t set repeated yet”


// Problem 1: findMissingAndRepeatedValues is non-static, but you’re calling it directly**
// System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));


// In main (which is static) you cannot call non-static methods directly.

// Either make the method static or create an object.

// ✅ Option 1 – Make method static:

// public static int[] findMissingAndRepeatedValues(int[][] grid) {
//     ...
// }


// Then you can call it directly from main:

// System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));


// ✅ Option 2 – Use an object:

// MissingAndRepeated obj = new MissingAndRepeated();
// System.out.println(Arrays.toString(obj.findMissingAndRepeatedValues(grid)));









public class MissingAndRepeated {
    // public static int[] findMissingAndRepeatedValues(int arr[]){
    //     int n = arr.length;
    //     int missing = -1;
    //     int repeated = -1;

    //     for(int i = 1; i<=n; i++){
    //         int count = 0;
    //         for(int j = 0; j<n; j++){
    //             if (arr[j] == i) {
    //                 count++;
    //             }
    //         }
    //         if (count == 0) {
    //             missing = i;
    //         }else if (count == 2) {
    //             repeated = i;
    //         }

    //         if (repeated != -1 && missing != -1) {
    //             break;
    //         }
    //     }

    //     return new int[]{repeated, missing};
    // }


//     public static int[] findMissingAndRepeatedValues(int arr[]) {
//         int n = arr.length;
//         int hash[] = new int[n+1]; //0 to n; // 0..n, all initialized to 0 automatically
//         // for(int i = 0; i<hash.length; i++){
//         //     hash[i] = 0; //by default zero hi hota h
//         // }

//         for(int i = 0; i<n; i++){
//             hash[arr[i]]++;
//         }

//         int missing = -1, repeated = -1;
//         for(int i = 1; i<=n; i++){
//             if (hash[i] == 0) {
//                 missing = i;
//             }else if (hash[i] == 2) {
//                 repeated = i;
//             }
            //    if (repeated != -1 && missing != -1) {
    //             break;
    //         }
//         }

//         return new int[]{repeated,missing};
//     }


//  Method 3 => OPTIMIZED Math trick
    public static int[] findMissingAndRepeatedValues(int arr[]){
        int n = arr.length;
        //S - Sn => //Sn = (n(n+1))/2
        //S2 - S2n //S2n = (n(n+1)(2n+1))/6
        long Sn = (n*(n+1))/2;
        long S2n = (n*(n+1)*(2*n+1))/6;

        long S = 0, S2 = 0;
        for(int i = 0; i<n; i++){
            S += (long)arr[i];
            S2 += (long)arr[i]*(long)arr[i];
        }

        long x1 = S - Sn; // repeated - missing
        long y1 = S2 - S2n; // repeated^2 - missing^2

        int repeatedPlusMissing = (int)(y1 / x1); // repeated + missing

        int repeated = ((int)x1 + repeatedPlusMissing)/2; //S
        int missing = (repeated - (int)x1);//Sn

        return new int[]{repeated,missing};
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 6, 2};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(arr)));
    }
}