class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for( int i =0; i < n; i++)
        {
            Arrays.fill(board[i],'.');
        }
        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean[2 * n - 1];
        boolean[] dia2 = new boolean[2 * n - 1];
        backtrack(0, n, board, col, dia1, dia2, result);
        return result;
        
    }

    public void backtrack( int row, int n, char[][] board, boolean[] col, boolean[] dia1, boolean[] dia2, List<List<String>> result)
    {
        if(row == n)
        {
            List<String> curr = new ArrayList<>();
            for( int i = 0; i < n; i++)
            {
                curr.add(new String(board[i]));
            }
            result.add(curr);
            return;
        }
            for( int c = 0; c < n; c++)
            {
                int d1 = row - c + n- 1;
                int d2 = row + c;

                if( col[c] || dia1[d1] || dia2[d2])
                {
                    continue;
                }
                board[row][c] = 'Q';
                col[c] = true;
                dia1[d1]= true;
                dia2[d2] = true;
                backtrack(row+1,n,board, col, dia1, dia2,result);
                board[row][c] = '.';
                col[c] = false;
                dia1[d1] = false;
                dia2[d2] = false;

            
        }
    }
}