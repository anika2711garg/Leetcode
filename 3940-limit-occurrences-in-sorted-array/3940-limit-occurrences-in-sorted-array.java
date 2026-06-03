class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int i = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            if (i < k || nums[j] != nums[i - k]) {
                nums[i++] = nums[j];
            }
        }

        return Arrays.copyOf(nums, i);
    }
}