class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n+1];
        int d = 0;
        int m = 0;
       
       for( int i =0; i < n; i++)
       {
           int count = nums[i];
           ans[count]++;
       }
       for( int i = 1; i <= n; i++)
       {
        if(ans[i] == 2)
        {
            d = i;
        }
        if(ans[i] == 0)
        {
            m = i;
        }
       }
        return new int[] {d,m};
    }
}