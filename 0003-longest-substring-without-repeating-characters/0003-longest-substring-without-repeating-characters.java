class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        int last = -1;
        int n = s.length();
        for( int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            if(map.containsKey(ch))
            {
                last = Math.max(last, map.get(ch));
            }
            map.put(ch,i);
            ans = Math.max(i-last,ans);
        }
        return ans;
    }
}