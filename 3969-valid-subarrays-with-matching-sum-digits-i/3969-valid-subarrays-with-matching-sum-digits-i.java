class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;

        long[] p = new long[n + 1];

        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + nums[i];
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                long sum = p[j + 1] - p[i];

                if (sum % 10 != x)
                    continue;

                long temp = sum;

                while (temp >= 10) {
                    temp /= 10;
                }

                if (temp == x) {
                    ans++;
                }
            }
        }

        return ans;
    }
}