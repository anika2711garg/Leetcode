class Solution {
    public int mySqrt(int x) {
       // return (int) Math.sqrt(x);
       if( x == 0 || x == 1)
       {
        return x;
       }
       long ans = 0;
       for( long i = 0; i <= x; i++)
       {
           if( i*i <= x)
           {
               ans = i;  
           }
           else
           {
            break;
            }
       }
       return (int)ans;

        
    }
}