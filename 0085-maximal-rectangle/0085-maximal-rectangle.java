class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] mat = new int[m][n];

        // convert char to int
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = matrix[i][j] - '0';
            }
        }

        // row-wise prefix widths
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i][j - 1];
                }
            }
        }

        int ans = 0;

        // fix each column
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int width = mat[i][j];
                if (width == 0) continue;

                // expand downward
                int currWidth = width;
                for (int k = i; k < m && mat[k][j] > 0; k++) {
                    currWidth = Math.min(currWidth, mat[k][j]);
                    int height = k - i + 1;
                    ans = Math.max(ans, currWidth * height);
                }

                // expand upward
                currWidth = width;
                for (int k = i; k >= 0 && mat[k][j] > 0; k--) {
                    currWidth = Math.min(currWidth, mat[k][j]);
                    int height = i - k + 1;
                    ans = Math.max(ans, currWidth * height);
                }
            }
        }

        return ans;
    }
}