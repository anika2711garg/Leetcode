class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for( int i = 0; i <= n/2; i++)
        {
        return nums[n/2];
        }
        return 0;
    }
}