import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals){
        // if(intervals.length == 0 || intervals == null){
        //     return new int[][]{};
        // }
        // Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        // int merged[][] = new int[intervals.length][intervals[0].length];//2 or intervals[0].length
        // int idx = -1;
        // for(int i = 0; i < intervals.length; i++){
        //     if (idx == -1 || merged[idx][1] < intervals[i][0]) {
        //         idx++;
        //         merged[idx] = intervals[i];
        //     }else{//overlapping condition

        //         merged[idx][1] = Math.max(merged[idx][1], intervals[i][1]);
        //     }
        // }

        // return Arrays.copyOf(merged, idx + 1);



        //Method 2 using ArrayList
        if (intervals.length <= 1) {
            return intervals; //or new int[][]{};
        }

        Arrays.sort(intervals, (a,b) -> a[0] -b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        // List<Integer> result = new ArrayList<>();//for 1D
        List<int[]> result = new ArrayList<>();

        for(int i = 1; i<intervals.length; i++){
            if (intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            }else{
                result.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start,end});

        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        int intervals[][] = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}

// Arrays.sort(arr, (a, b) -> {
//     if (a[0] != b[0]) {
//         return a[0] - b[0];
//     } else {
//         return a[1] - b[1];
//     }
// });

// Example of sorting a 2D array based on the first column primarily and second column secondarily.