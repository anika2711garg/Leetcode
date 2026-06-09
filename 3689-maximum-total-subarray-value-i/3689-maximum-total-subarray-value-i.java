class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int max_i = Integer.MIN_VALUE;
        int min_i = Integer.MAX_VALUE;
        for( int i = 0; i < n; i++)
        {
            max_i = Math.max(max_i, nums[i]);
            min_i = Math.min(min_i, nums[i]);
        }

        return (long)  k * (max_i - min_i);
        
    }
}