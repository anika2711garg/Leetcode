class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int total = 0;
        int count = 0;

        for( int i = 0; i < n; i++)
        {
            total += nums[i];
        }
        if(total % 2 == 1)
        {
            return 0;
        }
        return n-1;
    }
}