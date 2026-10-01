class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // Before newInterval
            if (intervals[i][1] < newInterval[0]) {
                ans.add(intervals[i]);
            }

            // After newInterval
            else if (intervals[i][0] > newInterval[1]) {
                ans.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    ans.add(intervals[j]);
                }
                return ans.toArray(new int[ans.size()][]);
            }
            // Overlap
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        // Add newInterval if it wasn't added yet
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}
