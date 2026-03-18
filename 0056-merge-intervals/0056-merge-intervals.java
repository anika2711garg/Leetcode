class Solution {
    public int[][] merge(int[][] intervals) {
        
        if( intervals.length  <= 1)// only one interval is there
        {
            return intervals;
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);// Sorting function for array Sorting
        List <int[]> result = new ArrayList<>();//new ArrayList created
        int[] current = intervals[0];
         
         for( int i = 1; i < intervals.length; i++)
         {
            int[] next = intervals[i];
            //Overlaping condition
            if( current[1] >= next[0])
            {
                current[1] = Math.max(current[1], next[1]);// merging by choosing maximum
            }
            else
            {
                result.add(current);
                current = next;
            }
         }
         result.add(current);
         return result.toArray(new int[result.size()][]);
    }
}