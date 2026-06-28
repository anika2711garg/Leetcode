import java.util.*;

class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);

        long ans = 0;
        int n = nums.length;

        int t = Math.min(k, Math.max(0, mul - 1));

        for (int i = 0; i < t; i++) {
            ans += 1L * nums[n - 1 - i] * (mul - i);
        }

        for (int i = t; i < k; i++) {
            ans += nums[n - 1 - i];
        }

        return ans;
    }
}