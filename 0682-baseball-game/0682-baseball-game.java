class Solution {
    public int calPoints(String[] operations)
    {
        int[] s = new int[operations.length];
        int i = 0;
        for( int idx = 0; idx < operations.length; idx++)
        {
           String op = operations[idx];
           if (op.equals("C")) {
                i--;
            } 
            else if (op.equals("D"))
             {
                s[i] = 2 * s[i - 1];
                i++;
            } 
            else if (op.equals("+")) 
            {
                s[i] = s[i - 1] + s[i - 2];
                i++;
            } 
            else {
                s[i++] = Integer.parseInt(op);
            }
        }

        int sum = 0;
        for (int k = 0; k < i; k++) {
            sum += s[k];
        }
        return sum;
    }
}

      