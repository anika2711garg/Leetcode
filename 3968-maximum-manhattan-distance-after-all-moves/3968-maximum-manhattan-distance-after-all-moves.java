class Solution {
    public int maxDistance(String moves) {
        int u = 0, d = 0, l = 0, r = 0, k = 0;

        for (char ch : moves.toCharArray())
        {
            if (ch == 'U') u++;
            else if (ch == 'D') d++;
            else if (ch == 'L') l++;
            else if (ch == 'R') r++;
            else k++;
        }

        return Math.abs(r - l) + Math.abs(u - d) + k;
    }
}