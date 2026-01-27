public class abcde {
    public static void reverse(int arr[]) {
        int start = 0;
        int end = arr.length-1;
        while (start<end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
        printArr(arr);
    }
    public static void printArr(int arr[]) {
        for(int num : arr) {
            System.out.print(num+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {3, 3, 5, 2, 8};
        reverse(arr);
    }
}
