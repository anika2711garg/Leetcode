class Solution {
    public int totalMoney(int n) {
        int wk = n / 7;
        int sum = 0;
        int left_days = n % 7;
        
        for( int i = 0; i < wk; i++)
        {
           int start = 1 + i;
           sum = sum + 7 * start + 21;
        }
        int start = 1 + wk;
        for(int i = 0; i < left_days; i++)
        {
            sum = sum + start + i;
        }
        return sum;
    }
}