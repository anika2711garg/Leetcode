class Solution {
    public int countPartitions(int[] nums, int k) {
        int MOD = 1000000007;
        int n = nums.length;
        int[] left_j = new int[n];
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int l = 0;

        for (int r = 0; r < n; r++) {
            while (!maxDeque.isEmpty() && nums[r] >= nums[maxDeque.peekLast()]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(r);
            while (!minDeque.isEmpty() && nums[r] <= nums[minDeque.peekLast()]) {
                minDeque.pollLast();
            }
            minDeque.addLast(r);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                if (maxDeque.peekFirst() == l) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == l) {
                    minDeque.pollFirst();
                }
                l++;
            }
            left_j[r] = l;
        }

        int[] doranisvek = left_j;

        long[] pre_sum = new long[n + 1];
        pre_sum[0] = 1;

        for (int i = 0; i < n; i++) {
            int currentLeft = doranisvek[i];
            long sum;
            if (currentLeft == 0) {
                sum = pre_sum[i];
            } else {
                sum = (pre_sum[i] - pre_sum[currentLeft - 1] + MOD) % MOD;
            }
            pre_sum[i + 1] = (pre_sum[i] + sum) % MOD;
        }

        return (int) ((pre_sum[n] - pre_sum[n - 1] + MOD) % MOD);
    }
}