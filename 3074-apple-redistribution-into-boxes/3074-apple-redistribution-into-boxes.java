class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total = 0;
        int n = apple.length;

        for( int i = 0; i < n; i++)
        {
            total = total + apple[i];
        }
        int used = 0;
        int curr = 0;

        Arrays.sort(capacity);
        int n1 = capacity.length;

        for( int j = n1 - 1; j >= 0; j--)
        {
            curr = curr + capacity[j];
            used++;

        if( curr >= total)
        {
           return used;
        }
        }
        return used;
        
    }
}