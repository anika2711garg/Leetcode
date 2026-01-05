class Solution {
    public long maxMatrixSum(int[][] matrix) {

        int negcnt = 0;
        long total = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                int value = matrix[i][j];

                if (value < 0) {
                    negcnt++;
                    value = -value;
                }

                total += value;
                min = Math.min(min, value);
            }
        }

        if (negcnt % 2 == 0)
            return total;

        return total - 2L * min;
    }
}
