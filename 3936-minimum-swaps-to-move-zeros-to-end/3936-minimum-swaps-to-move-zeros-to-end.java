class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int count = 0;
        for( int i = 0; i < n; i++)
        {
            if( nums[i] == 0)
            {
                count++;
            }
        }
        if(count == 0)
        {
            return 0;
        }
        int x = 0;
        for( int i = n - 1; i >= (n-count); i--)
        {
            if(nums[i] == 0)
            {
                x++;
            }
        }
        return (count-x);
    }
}