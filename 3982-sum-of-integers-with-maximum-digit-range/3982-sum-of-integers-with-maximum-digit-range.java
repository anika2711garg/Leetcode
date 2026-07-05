class Solution {
    public int maxDigitRange(int[] nums) {
        int n = nums.length;
         int maxR = -1;

        for (int i = 0; i < n; i++) {
            int r = getRange(nums[i]);
            maxR = Math.max(maxR, r);
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (getRange(nums[i]) == maxR) {
                sum += nums[i];
            }
        }

        return sum;
    }
     private int getRange(int num) {
        int min = 9;
        int max = 0;

        while (num > 0) {
            int d = num % 10;
            min = Math.min(min, d);
            max = Math.max(max, d);
            num /= 10;
        }

        return max - min;
    }
}