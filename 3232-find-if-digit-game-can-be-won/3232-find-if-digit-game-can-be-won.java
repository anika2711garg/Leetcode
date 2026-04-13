class Solution {
    public boolean canAliceWin(int[] nums) {
        int n = nums.length;
        int a = 0;
        int b = 0;
        for( int i = 0; i < n; i++)
            {
                if (nums[i] < 10)
                    {
                        a = a + nums[i];
                    }
                else
                {
                    b = b + nums[i];
                }
            }
        if (a == b)
        {
            return false;
        }
        return true;
        
    }
}