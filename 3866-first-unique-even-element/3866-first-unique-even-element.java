class Solution {
    public int firstUniqueEven(int[] nums) {
        int n = nums.length;

        for( int i = 0; i < n; i++)
            {
                if( nums[i] % 2 == 0)
                {
                 int cani = 0;
                for(int j = 0; j < n; j++)
                {
                    if(nums[i] == nums[j])
                    {
                        cani++;
                    }
                }
                if(cani == 1){
                    return nums[i];
                }
            }
    }
        return -1;
    }
}