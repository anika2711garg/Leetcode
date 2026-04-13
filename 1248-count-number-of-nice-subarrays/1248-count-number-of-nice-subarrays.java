class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       return generate(nums,k) - generate(nums, k-1);
    }

    public int generate( int nums[], int k)
    {
        int n = nums.length;

        int i = 0;
        int j = 0;
        int count = 0;

        while ( j < n)
        {
            if( nums[j] % 2 != 0)
            {
                k--;
            }

            while( k < 0)
            {
                if( nums[i] % 2 != 0)
                {
                    k++;
                }
                i++;
            }
                 
          count = count + j - i + 1;
          j++;
        }
        return count;
        
    }
}