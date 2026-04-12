class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;  
        int right = getMaxPile(piles);
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(piles, h, mid)) {
                ans = mid;        
                right = mid - 1;  
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private int getMaxPile(int[] piles) {
        int max = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }
        return max;
    }

    private boolean canEatAll(int[] piles, int h, int k) {
        int hoursNeeded = 0;

        for (int i = 0; i < piles.length; i++) {
            int pile = piles[i];

            hoursNeeded += (pile + k - 1) / k;

            if (hoursNeeded > h) return false;
        }

        return true;
    }
}