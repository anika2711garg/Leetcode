class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;

        int cnt_5 = 0;
        int cnt_10 = 0;

        for(int i = 0; i < n; i++)
        {
           if( bills[i] == 5)
           {
            cnt_5++;
           }
          else if( bills[i] == 10)
           {
            if(cnt_5 == 0)
            {
                return false;
            }
            cnt_5 = cnt_5 - 1;
            cnt_10 = cnt_10 + 1;

           }
           else if( bills[i] == 20)
           {
            if(cnt_5 >= 1 && cnt_10 >= 1)
            {
                cnt_5 = cnt_5 - 1;
                cnt_10 = cnt_10 - 1;
            }
            else if (cnt_5 >= 3)
            {
                cnt_5 = cnt_5 - 3;
            }
            else
            {
                return false;
            }
           }



        }
        return true;
        
    }
}