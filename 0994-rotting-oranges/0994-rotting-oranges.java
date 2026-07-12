class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for( int i = 0; i < n; i++)
        {
            for( int j = 0; j < m; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }
        if(fresh == 0)
        {
            return 0;
        }
        int min = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1},{0,-1}};
        while( !q.isEmpty())
        {
             int size = q.size();
             boolean rotten = false;

             for( int k = 0; k < size; k++)
             {
                int[] cur = q.poll();

                for( int[] d: dirs)
                {
                    int x = cur[0] + d[0];
                    int y = cur[1] + d[1];

                    if( x >= 0 && y >=0 && x < n && y < m && grid[x][y] == 1)
                    {
                        grid[x][y] = 2;
                        fresh--;
                        q.offer(new int[]{x,y});
                        rotten = true;
                    }
                }
             }
             if(rotten)
            {
                min++;
            }
        }

           if (fresh == 0) 
           {
           return min;
               } 
               else
                {
    return -1;
}


        
        
    }
}