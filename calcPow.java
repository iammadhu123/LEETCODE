public class calcPow {
    public static double myPow(double x, int n){
        return Pow(x,(long) n);
    }
    public static double Pow(double x, long n){
        // if (n == 0) {
        //     return 1;
        // }
        // if (n < 0) {
        //     return 1/Pow(x, -n);
        // }

        // long is used to avoid overflow when n = Integer.MIN_VALUE
        // double xPown = Pow(x, n/2);

        // if (n % 2 == 0) {
        //     return xPown*xPown;
        // }else{
        //     return xPown*xPown*x;
        // }

//         If you use Math.pow(x, n) 👇
//        ⏱️ Time Complexity (TC)
//        O(1) (constant time) ✅

        double xPown = Math.pow(x,n); //no use in built function in interview
        return xPown;
    }
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }
}
