class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        for( int i = 1; i <= n ; i++)
        {
            ans.add(i);
        }
        int fact = 1;
        for(int i = 1; i < n; i++)
        {
            fact = fact * i;
        }
        k = k-1;
        StringBuilder res = new StringBuilder();
        while(true)
        {
            int index  = k / fact;
            res.append(ans.get(index));
            ans.remove(index);
            if(ans.size() == 0)
            {
                break;
            }
            k = k % fact;
            fact = fact /ans.size();
        }
        return res.toString();      
    }
}