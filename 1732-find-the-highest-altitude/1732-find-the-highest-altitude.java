class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int currAlt = 0;
        int max = currAlt;
        for( int i = 0; i < n; i++)
        {
         currAlt += gain[i];
            max = Math.max(max, currAlt);
        }

        return max;
    }
}   