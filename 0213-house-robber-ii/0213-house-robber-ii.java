class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if( n == 1)
        {
            return nums[0];
        }
        int case1 = rob2(nums,0,n-2);
        int case2 = rob2(nums,1,n-1);
          
          return Math.max(case1, case2);
    }

        public int rob2(int[] nums, int st, int ed)
        {
            int n = nums.length;
            int[] dp = new int[n];

            dp[st] = nums[st];
            if(st+1 <= ed)
        {
             dp[st + 1] = Math.max(nums[st], nums[st+1]);
        }
         for(int i = st + 2; i <= ed; i++)
          {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[ed];
    }
        }