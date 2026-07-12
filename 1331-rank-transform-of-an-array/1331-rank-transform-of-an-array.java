class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int[] temp = arr.clone();
        Arrays.sort(temp);
        int rank = 1;
        int x = temp.length;
        for( int i = 0; i < x; i++)
        {
            if(!map.containsKey(temp[i])){
            map.put(temp[i], rank);
            rank++;
            }
        }
        int[] ans = new int[n];
        for( int i = 0; i < n; i++)
        {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}