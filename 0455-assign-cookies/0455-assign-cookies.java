class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int ans = 0;

        int i = 0, j = 0;
        while(i < g.length && j < s.length) {
            if(s[j] >= g[i]) {
                ans++;
                i++;
            }
            j++;
        }

        return ans;
    }
}
// A child is satisfied if:
// cookie size >= child's greed
// Goal: maximum number of satisfied children.

// We use the smallest cookie that can satisfy the current smallest child.