class Solution {
    public int nonSpecialCount(int l, int r) {
        int j = (int)Math.sqrt(r);
        int ans = 0;

        for (int i = 2; i <= j; i++)
            {
            if (isPrime(i)) {
                int sq = i * i;
                if (sq >= l && sq <= r)
                {
                    ans++;
                }
            }
        }

        return (r - l + 1) - ans;
    }

    private boolean isPrime(int n) 
    {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) 
        {
            if (n % i == 0) 
                return false;
        }

        return true;
    }
}