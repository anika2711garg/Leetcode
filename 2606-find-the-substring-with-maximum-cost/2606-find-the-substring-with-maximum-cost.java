class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        
        int[] map = new int[26];
        
        for (int i = 0; i < 26; i++)
            {
            map[i] = i + 1;
        }
        
        for (int i = 0; i < chars.length(); i++) 
        {
            char ch = chars.charAt(i);
            map[ch - 'a'] = vals[i];
        }
        
        int maxsum = 0;
        int currsum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int val = map[s.charAt(i) - 'a'];
            
            currsum += val;

            if (currsum < 0) {
                currsum = 0;
            }
            
            maxsum = Math.max(maxsum, currsum);
        }
        
        return maxsum;
    }
}