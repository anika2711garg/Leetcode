class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int n = grid.length;
        
        int[] freq = new int[n * n + 1];
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int num = grid[i][j];
                freq[num]++;
            }
        }
        
        int repeated = 0;
        int missing = 0;

        for(int i = 1; i <= n * n; i++)
        {
            if(freq[i] == 2)
            {
                repeated = i;
            }
            
            if(freq[i] == 0)
            {
                missing = i;
            }
        }
        
        return new int[]{repeated, missing};
    }
}