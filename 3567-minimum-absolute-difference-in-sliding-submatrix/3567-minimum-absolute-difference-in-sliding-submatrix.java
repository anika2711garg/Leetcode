class Solution {
   public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                List<Integer> elements = new ArrayList<>();
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        elements.add(grid[x][y]);
                    }
                }
                Collections.sort(elements);
                
                List<Integer> unique = new ArrayList<>();
                if (!elements.isEmpty()) {
                    unique.add(elements.get(0));
                    for (int p = 1; p < elements.size(); p++) {
                        if (!elements.get(p).equals(unique.get(unique.size() - 1))) {
                            unique.add(elements.get(p));
                        }
                    }
                }
                
                if (unique.size() <= 1) {
                    ans[i][j] = 0;
                } else {
                    int minDiff = Integer.MAX_VALUE;
                    for (int p = 1; p < unique.size(); p++) {
                        minDiff = Math.min(minDiff, unique.get(p) - unique.get(p - 1));
                    }
                    ans[i][j] = minDiff;
                }
            }
        }
        return ans;
    }
}