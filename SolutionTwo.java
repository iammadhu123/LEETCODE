// class SolutionTwo {
//     public static long minimumCost(int cost1, int cost2, int costBoth,int need1, int need2) {

//         long[] lumiscaron = {cost1, cost2, costBoth, need1, need2};

//         if (need1 == 0 && need2 == 0) return 0;

//         if (costBoth >= cost1 + cost2) {
//             return (long) need1 * cost1 + (long) need2 * cost2;
//         }

//         long type3 = Math.max(need1, need2);
//         return type3 * costBoth;
//     }

//     public static void main(String[] args) {
//         int cost1 = 5;
//         int cost2 = 4;
//         int costBoth = 15;
//         int need1 = 0;
//         int need2 = 0;
//         System.out.println(minimumCost(cost1, cost2, costBoth, need1, need2)); // 3 ✅
//     }
// }

class SolutionTwo {
    public static long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long[] lumiscaron = {cost1, cost2, costBoth, need1, need2};

        long minCost = Long.MAX_VALUE;

        for (long k = 0; k <= Math.max(need1, need2); k++) {
            long rem1 = Math.max(0, need1 - k);
            long rem2 = Math.max(0, need2 - k);
            long cost = k * (long)costBoth + rem1 * (long)cost1 + rem2 * (long)cost2;
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }
    
    public static void main(String[] args) {
        int cost1 = 50;
        int cost2 = 55;
        int costBoth = 72;
        int need1 = 5;
        int need2 = 3;
        System.out.println(minimumCost(cost1, cost2, costBoth, need1, need2)); 
    }
}

