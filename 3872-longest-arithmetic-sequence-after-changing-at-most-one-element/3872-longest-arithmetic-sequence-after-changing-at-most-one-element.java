class Solution {
    public int longestArithmetic(int[] nums) {
        int n = nums.length;
        if (n <= 3) 
        {
            return n;
        }
     int[] l_ani = new int[n];
        int[] r_ani = new int[n];

        l_ani[0] = 1;
        l_ani[1] = 2;

        for (int i = 2; i < n; i++) 
        {
         if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2])
         {
            l_ani[i] = l_ani[i-1] + 1;
         }
        else
         {
               l_ani[i] = 2;
         }
        }
            r_ani[n-1] = 1;
        r_ani[n-2] = 2;

        for (int i = n-3; i >= 0; i--) 
      {
            if (nums[i+1] - nums[i] == nums[i+2] - nums[i+1])
    {
      r_ani[i] = r_ani[i+1] + 1;
            }
            else
            {       
                r_ani[i] = 2;
            }
        }
       int anians = 2;
        for (int i = 0; i < n; i++)
            {
            anians = Math.max(anians, Math.max(l_ani[i], r_ani[i]) + 1);
            }
        for (int i = 1; i < n-1; i++)
            {
            int anidiff = nums[i+1] - nums[i-1];
            if (anidiff % 2 == 0)
            {
                int ani = anidiff / 2;
                int le = 1;
                if (i >= 2 && nums[i-1] - nums[i-2] == ani)
                {
                    le = l_ani[i-1];
                }
    int ri = 1;
                if (i <= n-3 && nums[i+2] - nums[i+1] == ani)
                {
                    ri = r_ani[i+1];
                }
                anians = Math.max(anians, le + ri + 1);
            }
        }
                 return Math.min(anians, n);
        
    }
}