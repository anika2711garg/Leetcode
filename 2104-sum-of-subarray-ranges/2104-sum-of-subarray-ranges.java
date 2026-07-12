class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] pse = new int[n];
        int[] nse = new int[n];
        int[] pge = new int[n];
        int[] nge = new int[n];

        Stack<Integer> s = new Stack<>();
        Stack<Integer> g = new Stack<>();

        // Previous Smaller and Previous Greater
        for (int i = 0; i < n; i++) {

            while (!s.isEmpty() && nums[s.peek()] > nums[i]) {
                s.pop();
            }
            pse[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);

            while (!g.isEmpty() && nums[g.peek()] < nums[i]) {
                g.pop();
            }
            pge[i] = g.isEmpty() ? -1 : g.peek();
            g.push(i);
        }

        s.clear();
        g.clear();

        // Next Smaller and Next Greater
        for (int i = n - 1; i >= 0; i--) {

            while (!s.isEmpty() && nums[s.peek()] >= nums[i]) {
                s.pop();
            }
            nse[i] = s.isEmpty() ? n : s.peek();
            s.push(i);

            while (!g.isEmpty() && nums[g.peek()] <= nums[i]) {
                g.pop();
            }
            nge[i] = g.isEmpty() ? n : g.peek();
            g.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {

            long min = (long) (i - pse[i]) * (nse[i] - i);
            long max = (long) (i - pge[i]) * (nge[i] - i);

            ans += max * nums[i];
            ans -= min * nums[i];
        }

        return ans;
    }
}