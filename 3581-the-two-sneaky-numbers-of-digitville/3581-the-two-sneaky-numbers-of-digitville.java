class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;

        Set<Integer> ans = new HashSet<>();
        int res[] = new int[2];
        int idx = 0;

        for( int i = 0; i < n; i++) 
        {
             if(ans.contains(nums[i]))
             {
                res[idx] = nums[i];
                idx++;
             }
             else
             {
                ans.add(nums[i]);
             }
        }  
        return res;    
    }
}