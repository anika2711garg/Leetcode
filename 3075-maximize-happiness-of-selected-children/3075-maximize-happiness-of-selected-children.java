class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long ans = 0;

        Arrays.sort(happiness);

        for( int i = 0; i < k; i++)
        {
            int value = happiness[n-i-1] - i;

            if(value > 0)
            {
                ans = ans + value;
            }
        }
        return ans;

        
    }
}