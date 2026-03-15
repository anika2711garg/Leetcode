class Solution {
    public long countCommas(long n) {
        long tot_com_ani = 0;
        long pow_1000_ani = 1000;
        while(pow_1000_ani <= n)
            {
                tot_com_ani += ( n- pow_1000_ani + 1);
                 if (pow_1000_ani > Long.MAX_VALUE / 1000) 
                 {
                break;
            }
                pow_1000_ani *= 1000;
            }
        return tot_com_ani;
        
    }
}