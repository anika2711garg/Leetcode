class Solution {
    final int MOD = 1000000007;
    int[][][] ans;
    int rows, cols;
    public int[] check(int r, int c) {
        if (r >= 0 && c >= 0) {
            return ans[r][c];
        }
        return new int[]{-1,0};
    }

    public int[] getMax(int[] left, int[] up, int[] diag) {
        int lm = left[0], um = up[0], dm = diag[0];
        int lp = left[1], upath = up[1], dp = diag[1];

        int macs = Math.max(lm, Math.max(um, dm));
       
        int pc = 0;
        if (lm == macs) {
            pc += lp;
        } 
        if (um == macs) {
            pc += upath;
        }
        if (dm == macs) {
            pc += dp;
        }

        return new int[]{macs, pc % MOD};
    }


    public int[] pathsWithMaxScore(List<String> board) {
        
        rows = board.size();
        cols = board.get(0).length();

        ans = new int[rows][cols][2];

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++) {
                char curr = board.get(r).charAt(c);
                if (curr == 'E') {
                    ans[r][c] = new int[]{0,1};
                    continue; 
                }
                if (curr == 'X') {
                    ans[r][c] = new int[]{-1,0};
                    continue;
                }
                if (curr == 'S') curr = '0';
                int num = curr - '0';

                int lr = r, lc = c-1;
                int ur = r-1, uc = c;
                int dr = r-1, dc = c-1;

                int[] left = check(lr,lc), up = check(ur, uc), diag = check(dr,dc);
                int[] macs = getMax(left, up, diag);
              
                if (macs[0] != -1) macs[0] += num;

                ans[r][c] = macs;
            }
        }
        int[] res = ans[rows-1][cols-1];
        res[0] = Math.max(0, res[0]);
        return res;
    }
}