class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n1 = g.length;
        int n2 = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;

        for( int j = 0; i < n1 && j < n2; j++)
        {
            if( g[i] <= s[j])
            {
                i++;
            }
        }
        return i;
    }
}