class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
        
    }
    public void backtrack( int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result)
    {
        int n = nums.length;
        if(current.size() == n)
        {
            result.add(new ArrayList<>(current));
            return;
        }

        for( int i = 0; i < n; i++)
        {
            if(used[i])
            {
                continue;
            }
            current.add(nums[i]);
            used[i] = true;
            backtrack(nums, current,used,result);
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}