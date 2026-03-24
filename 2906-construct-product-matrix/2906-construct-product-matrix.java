class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        int n = grid.length;
        int m = grid[0].length;

       int[][] ans = new int[n][m]; 
       //store elements other than current element
       long suffix = 1;

        // bottom-right to top-left
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                // store suffix 
                ans [i][j] = (int) suffix;

                // update suffix including current element
                suffix = (suffix * grid[i][j]) % MOD;
            }
        }
          long prefix = 1;

        //  top-left to bottom-right
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // multiply prefix with stored suffix
                ans [i][j] = (int) (((long) ans [i][j] * prefix) % MOD);

                // update prefix including current element
                prefix = (prefix * grid[i][j]) % MOD;
            }
        }

        return ans;
    }
}