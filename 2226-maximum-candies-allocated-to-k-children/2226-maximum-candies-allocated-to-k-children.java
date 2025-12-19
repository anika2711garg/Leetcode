class Solution {
    public int maximumCandies(int[] candies, long k) 
    {
        int n = candies.length;
        int max = 0;

        for(int c: candies)
            {
                max = Math.max(max,c);
            }
        int low = 1;
        int high = max;

        int ans = 0;

        while( low <= high)
            {
                int mid = low + (high - low)/2;
                long count = 0;

                for( int c: candies)
                    {
                        count = count + c/mid;
                    }
                if(count >= k)
                {
                    ans = mid;
                    low = mid+1;
                }
                else
                {
                    high = mid - 1;
                }
            }
        
        return ans;
    }
}