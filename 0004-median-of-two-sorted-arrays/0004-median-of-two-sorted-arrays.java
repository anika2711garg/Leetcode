class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[n+m];
        for( int i = 0; i < n; i++)
        {
            result[i] = nums1[i];
        }
        for( int i = 0; i < m; i++)
        {
            result[n+i] = nums2[i];
        }
       Arrays.sort(result);

       int length = n + m;
       if( length % 2 == 1)
       {
        return result[length/2];
       }
       else
       {
        int a = result[length/2];
         int b = result[length/2 - 1];
           return (a + b) / 2.0;
       }
    }
}