class Solution {

    public int solve(int num, int dig) {
        int ans = 0;

        while (num > 0) {
            int d = num % 10;
            num = num / 10;

            if (d == dig) {
                ans++;
            }
        }

        return ans;
    }

    public int countDigitOccurrences(int[] nums, int digit) {
    int ans = 0;

    for (int i = 0; i < nums.length; i++) {
        int x = nums[i];
        ans = ans + solve(x, digit);
    }

    return ans;
}
}