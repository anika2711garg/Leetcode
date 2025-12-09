class Solution {
    int MOD = 1000000007;
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for (int x : nums)
         {
            right.put(x, right.getOrDefault(x, 0) + 1);
        }        
    long ans = 0;

        for (int x : nums) {

            right.put(x, right.get(x) - 1);
            if (right.get(x) == 0) 
            right.remove(x);

            int target = 2 * x;

            long leftCount  = left.getOrDefault(target, 0);
            long rightCount = right.getOrDefault(target, 0);

            ans = (ans + (leftCount * rightCount) % MOD) % MOD;

            left.put(x, left.getOrDefault(x, 0) + 1);
        }

        return (int) ans;
    }
}