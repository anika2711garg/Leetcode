class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;

        long maxLeft = nums[0];
        long ans = 0;

        for (int j = k; j < n; j++) {
            maxLeft = Math.max(maxLeft, nums[j - k]);
            ans = Math.max(ans, maxLeft + nums[j]);
        }

        return (int) ans;
    }
}