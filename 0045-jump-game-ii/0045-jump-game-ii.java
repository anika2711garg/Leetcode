class Solution {
    public int jump(int[] nums) {

        int jumps = 0;
        int currEnd = 0;
        int currFar = 0;

        for (int i = 0; i < nums.length - 1; i++) 
        {
            currFar = Math.max(currFar, i + nums[i]);

            if (i == currEnd) 
            {
                jumps++;
                currEnd = currFar;
            }
        }
        return jumps;
    }
}
