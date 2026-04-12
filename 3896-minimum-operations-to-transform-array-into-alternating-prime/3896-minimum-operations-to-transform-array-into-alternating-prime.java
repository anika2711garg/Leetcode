class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int n = nums.length;
        for( int i = 0; i < n; i++)
        {
            int val = nums[i];
            if(i % 2 == 0)
            {
                while(!isPrime(val))
                {
                    val++;
                    count++;
                }
            }
            else
            {
                while(isPrime(val))
                {
                    val++;
                    count++;
                }
            }
        }
        return count;      
    }
    private boolean isPrime(int n)
    {
        if( n <= 1)
        {
            return false;     
        }
        for( int i = 2; i * i <= n; i++)
        {
              if (n % i == 0) return false;
        }

        return true;
        }
    }