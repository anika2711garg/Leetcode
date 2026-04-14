class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int min1 = 10;
        int min2 = 10;
        int min = 10;

        for (int i = 0; i < n1; i++) 
        {
            min1 = Math.min(min1, nums1[i]);
        }

        for (int i = 0; i < n2; i++)
            {
            min2 = Math.min(min2, nums2[i]);
        }
 
        for (int i = 0; i < n1; i++) 
        {
            for (int j = 0; j < n2; j++) 
            {
                if (nums1[i] == nums2[j]) 
                {
                    min = Math.min(min, nums1[i]);
                }
            }
        }
        if (min != 10) {
            return min;
        }

        return Math.min(min1 * 10 + min2, min2 * 10 + min1);
    }
}