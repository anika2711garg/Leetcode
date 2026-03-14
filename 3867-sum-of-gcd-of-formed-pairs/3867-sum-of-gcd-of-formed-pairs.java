class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] p_ani = new int[n];

        int mx_ani = 0;

        for(int i = 0; i < n; i++) 
        {
            mx_ani = Math.max(mx_ani, nums[i]);
            p_ani[i] = gcd(nums[i], mx_ani);
        }

         Arrays.sort(p_ani);
    long sum_ani = 0;

        int l_ani = 0;
        int r_ani = n - 1;

         while(l_ani < r_ani)
             {
            sum_ani += gcd(p_ani[l_ani], p_ani[r_ani]);
            l_ani++;
            r_ani--;
        }
        return sum_ani;
    }
       private int gcd(int a, int b)
    {
        while(b != 0)
            {
            int t_ani = b;
            b = a % b;
            a = t_ani;
        }
        return a;
        
    }
}