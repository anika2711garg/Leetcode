class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int cur_sum = 0;
        int max_sum = nums[0];

        for( int i = 0; i < n; i++)
        {
        cur_sum = Math.max(nums[i], cur_sum + nums[i]);
        max_sum = Math.max(cur_sum,max_sum);

        }
        return max_sum;
    }
}