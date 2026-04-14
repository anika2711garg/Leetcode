class Solution {
    public int minLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> freq = new HashMap<>();
        int i = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++)
            {
                int val = nums[j];
                freq.put(val, freq.getOrDefault(val, 0) + 1);
            if (freq.get(val) == 1) {
                sum += val;
            }
            
         while(sum >= k)
             {
                  ans = Math.min(ans, j - i + 1);
                 int remove = nums[i];
                 freq.put(remove, freq.get(remove)-1);
                 if (freq.get(remove) == 0)
                 {
                 sum -= remove;
                  }
                  i++;
             }
               
            }
         if (ans == Integer.MAX_VALUE) {
               return -1;
            } else {
        return ans;
         }
          
    }
}