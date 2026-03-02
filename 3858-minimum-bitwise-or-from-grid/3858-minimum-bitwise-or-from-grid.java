class Solution {
    public int minimumOR(int[][] grid) {
        int res = 0;

        for( int b = 17; b >= 0; b--)
            {
                int m = res | ((1 << b) - 1);
                boolean pos = true;

                for( int[] row : grid)
                    {
                        boolean fnd = false;

                        for( int num : row)
                            {
                                if(( num | m) == m)
                                {
                                    fnd = true;
                                    break;
                                }
                            }
                        if( !fnd)
                        {
                            pos = false;
                            break;
                        }
                    }
                if( !pos)
                {
                    res |= ( 1 << b);
                }
            }
        return res;
    }
}