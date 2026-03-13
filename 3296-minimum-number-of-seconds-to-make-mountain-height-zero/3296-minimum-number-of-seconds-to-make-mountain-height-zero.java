class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        // We binary search the minimum time required
        long left = 1;              // minimum possible time
        long right = (long)1e18;    // very large upper bound for time
        long ans = right;           // store best answer

        // Binary search loop
        while(left <= right)
        {
            long mid = left + (right - left) / 2;  // candidate time

            // Check if workers can reduce mountain in 'mid' seconds
            if(canFinish(mid, mountainHeight, workerTimes))
            {
                ans = mid;          // possible answer
                right = mid - 1;    // try to find smaller time
            }
            else
            {
                left = mid + 1;     // need more time
            }
        }

        return ans;                 // minimum time found
    }

    // Helper function to check if mountain can be reduced in given time
    private boolean canFinish(long time, int height, int[] workerTimes)
    {
        long totalHeightReduced = 0;

        // Check contribution of every worker
        for(int t : workerTimes)
        {
            /*
            For worker with base time t:

            Time to reduce x height =
            t + 2t + 3t + ... + xt
            = t * (1 + 2 + 3 + ... + x)

            Sum formula:
            1 + 2 + ... + x = x(x+1)/2

            So total time = t * x(x+1)/2

            We need:
            t * x(x+1)/2 ≤ time

            Solve for x using quadratic formula:
            x = (sqrt(1 + 8*time/t) - 1) / 2
            */

            long val = (long)Math.sqrt(1 + 8.0 * time / t);
            long x = (val - 1) / 2;

            totalHeightReduced += x;

            // Early stopping if mountain already reduced
            if(totalHeightReduced >= height)
                return true;
        }

        // Not enough height reduced
        return false;
    }
}