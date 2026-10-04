class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        while(i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!pq.isEmpty() && pq.peek() < start) {
                pq.poll(); 
            }

            pq.offer(end); //put current interval's end
            i++;
        }

        return pq.size();
    }
}

// pq.peek() always gives the smallest element