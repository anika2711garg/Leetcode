class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for( int i = 0; i < n; i++)
        {
            int num = nums[i];
             int d = 0;
             while(num > 0)
             {
                d += num %10;
                num /= 10;
             }
             ans = Math.min(ans,d);
        }
        return ans;
    }
}