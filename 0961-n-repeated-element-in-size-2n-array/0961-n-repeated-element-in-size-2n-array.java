class Solution {
    public int repeatedNTimes(int[] nums) {
        int m = nums.length;
        Arrays.sort(nums);

        for( int i = 0; i < m; i++)
        {
             if( nums[i] == nums[i+1])
             {
                return nums[i];
             }
        }
        return -1;
    }
}