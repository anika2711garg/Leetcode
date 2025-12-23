class Solution {
    public int minDeletionSize(String[] s) {
        int n = s.length;
        int m = s[0].length();
        int count = 0;

        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n - 1; row++) {
                if (s[row].charAt(col) > s[row + 1].charAt(col)) {
                    count++;   
                    break;     
                }
            }
        }
        return count;
    }
}
