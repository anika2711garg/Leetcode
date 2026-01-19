class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] pre = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) 
        {
            for (int j = 1; j <= n; j++) 
            {
                pre[i][j] = mat[i - 1][j - 1]
                          + pre[i - 1][j]
                          + pre[i][j - 1]
                          - pre[i - 1][j - 1];
            }
        }

        int low = 0;
        int high = Math.min(m, n);

        while (low < high) 
        {
            int mid = (low + high + 1) / 2;
            if (existsSquare(pre, m, n, mid, threshold)) 
            {
                low = mid;
            } else 
            {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean existsSquare(int[][] pre, int m, int n, int len, int threshold) 
    {
        for (int i = 0; i + len <= m; i++)
         {
            for (int j = 0; j + len <= n; j++)
             {
                int sum = pre[i + len][j + len]
                        - pre[i][j + len]
                        - pre[i + len][j]
                        + pre[i][j];
                if (sum <= threshold)
                 {
                    return true;
                }
            }
        }
        return false;
    }
}
