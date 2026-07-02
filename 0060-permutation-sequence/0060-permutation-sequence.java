class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        for( int i = 1; i <= n; i++)
        {
            ans.add(i);
        }
        int f = 1;
        for( int i = 1; i < n; i++)
        {
            f = f*i;
        }
        k = k-1;
        StringBuilder res = new StringBuilder();
        while(true)
        {
            int idx = k / f;
            res.append(ans.get(idx));
            ans.remove(idx);
            if(ans.size() == 0)
            {
                break;
            }
            k = k % f;
            f = f/(ans.size());
        }
        return res.toString();
        
    }
}