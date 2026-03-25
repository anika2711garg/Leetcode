class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if( n == 0)
        {
            return 0;
        }
        int index = 0;
        for( int i = 0; i < n - 1; i++)
        {
            if(nums[i] != nums[i + 1])
            {
                nums[index] = nums[i];
                index++;
            }
        }
         nums[index] = nums[n - 1];

        return index+1;
    }
}