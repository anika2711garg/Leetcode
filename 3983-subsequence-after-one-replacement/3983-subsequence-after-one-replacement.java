class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        String[] ans = {s, t};

        int m = s.length(), n = t.length();

        int[] pre = new int[m];
        java.util.Arrays.fill(pre, -1);

        int j = 0;
        for (int i = 0; i < m; i++) {
            while (j < n && s.charAt(i) != t.charAt(j)) j++;
            if (j == n) break;
            pre[i] = j++;
        }

        if (pre[m - 1] != -1) return true;

        int[] suf = new int[m];
        java.util.Arrays.fill(suf, -1);

        j = n - 1;
        for (int i = m - 1; i >= 0; i--) {
            while (j >= 0 && s.charAt(i) != t.charAt(j)) j--;
            if (j < 0) break;
            suf[i] = j--;
        }

        for (int i = 0; i < m; i++) {
            int left = (i == 0) ? -1 : pre[i - 1];
            int right = (i == m - 1) ? n : suf[i + 1];

            if ((i == 0 || pre[i - 1] != -1) &&
                (i == m - 1 || suf[i + 1] != -1) &&
                left < right - 1) {
                return true;
            }
        }

        return false;
    }
}