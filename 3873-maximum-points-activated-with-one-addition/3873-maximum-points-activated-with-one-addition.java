class Solution {
    class ani_uni {
        HashMap<Long, Long> ani_nodes = new HashMap<>();
        long ani_locate(long ani_val) 
        {
            if (!ani_nodes.containsKey(ani_val)) 
            {
                ani_nodes.put(ani_val, ani_val);
                return ani_val;
            }
         if (ani_nodes.get(ani_val) == ani_val) 
         {
                return ani_val;
            }
            long parent = ani_locate(ani_nodes.get(ani_val));
       ani_nodes.put(ani_val, parent);
            return parent;
        }
        void ani_combine(long ani_a, long ani_b)
        {
          long ani_ra = ani_locate(ani_a);
            long ani_rb = ani_locate(ani_b);
            if (ani_ra != ani_rb) {
                ani_nodes.put(ani_ra, ani_rb);
            }
        }
    }
    public int maxActivated(int[][] points) {
        if (points.length == 0) 
        {
       return 1;
        }     
     ani_uni ani_dsu = new ani_uni();
     long ani_gap = 4000000000L;
        for (int[] ani_item : points)
            {
            ani_dsu.ani_combine((long) ani_item[0], (long) ani_item[1] + ani_gap);
        }
        HashMap<Long, Integer> ani_map = new HashMap<>();
        for (int[] ani_it : points)
            {
            long ani_ro = ani_dsu.ani_locate((long) ani_it[0]);      
         ani_map.put(ani_ro, ani_map.getOrDefault(ani_ro, 0) + 1);
        }
        List<Integer> ani_li = new ArrayList<>();
        for (Map.Entry<Long, Integer> ani_ptr : ani_map.entrySet())
            {
            ani_li.add(ani_ptr.getValue());
        }
      Collections.sort(ani_li, Collections.reverseOrder());
    if (ani_li.size() >= 2) {
            return ani_li.get(0) + ani_li.get(1) + 1;
        }
     return ani_li.get(0) + 1;
        
    }
}