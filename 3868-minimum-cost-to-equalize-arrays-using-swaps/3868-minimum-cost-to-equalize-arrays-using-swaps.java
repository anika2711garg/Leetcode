class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Map<Integer, Integer> t_ani = new HashMap<>();
        Map<Integer, Integer> c_ani = new HashMap<>();

        for( int i = 0; i < n1; i++)
            {
               t_ani.put(nums1[i], t_ani.getOrDefault(nums1[i],0) + 1); 
             t_ani.put(nums2[i], t_ani.getOrDefault(nums2[i],0) + 1);
                 c_ani.put(nums1[i], c_ani.getOrDefault(nums1[i],0) + 1); 
            }
        int d_ani = 0;
        for (Map.Entry<Integer, Integer> e_ani : t_ani.entrySet())
            {
            int v_ani = e_ani.getKey();
            int tc_ani = e_ani.getValue();
                if( tc_ani % 2 != 0)
                {
                    return -1;
                }
        int tar_ani = tc_ani / 2;
            int cur_ani = c_ani.getOrDefault(v_ani, 0);

                d_ani += Math.abs(cur_ani - tar_ani);
    }
        return d_ani/2;
}
}