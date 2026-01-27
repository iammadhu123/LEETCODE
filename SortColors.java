public class SortColors {
    public static void sortColors(int[] colors){
        int low = 0, mid = 0, high = colors.length-1; //low for 0, mid for 1, high for 2;

        while (mid<=high) {
            if (colors[mid] == 0) {
                swap(colors, low, mid);
                low++;
                mid++;
            }else if (colors[mid] == 1) {
                mid++;
            }else{
                swap(colors, mid, high);
                high--;
            }
        }



        // int k = 0;
        // int temp[] = new int[colors.length];
        // for(int c : colors){
        //     if (c == 0) {
        //         temp[k++] = 0;
        //     }
        // }
        // for(int c : colors){
        //     if (c == 1) {
        //         temp[k++] = 1;
        //     }
        // }

        // for(int c : colors){
        //     if (c == 2) {
        //         temp[k++] = 2;
        //     }
        // }

        // for (int i = 0; i < colors.length; i++)
        //     colors[i] = temp[i];

        // for (int color : colors) {
        //     System.out.print(color + " ");
        // }


        //Method 3
        // int count0 = 0, count1 = 0, count2 = 0;
        
        // for(int  i = 0;i<colors.length; i++) {
        //     if (colors[i] == 0) {
        //         count0++;
        //     }else if (colors[i] == 1) {
        //         count1++;
        //     }else{
        //         count2++;
        //     }
        // }

        // for(int  j = 0; j<count0; j++){
        //     colors[j] = 0;
        // }
        // for(int  j = count0; j<count0+count1; j++){
        //     colors[j] = 1;
        // }
        // for(int  j = count0+count1; j<colors.length; j++){
        //     colors[j] = 2;
        // }        


        //OPTIMAL=> Dutch National Flag Algo

    }

    public static void swap(int colors[], int i, int j){
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;

    }
    public static void main(String[] args) {
        int[] colors = {2, 0, 2, 1, 1, 0};
        sortColors(colors);
        for (int color : colors) {
            System.out.print(color + " ");
        }
    }
}


// class Solution {
//     public void sortColors(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();

//         for(int num : nums){
//             map.put(num, map.getOrDefault(num, 0)+1);
//         }

//         int index = 0;

//         int count0 = map.getOrDefault(0, 0);
//         for(int i=0; i<count0; i++){
//             nums[index++] = 0;
//         }
//         int count1 = map.getOrDefault(1, 0);
//         for(int i=0; i<count1; i++){
//             nums[index++] = 1;
//         }
//         int count2 = map.getOrDefault(2, 0);
//         for(int i=0; i<count2; i++){
//             nums[index++] = 2;
//         }
        
        
//     }
// }