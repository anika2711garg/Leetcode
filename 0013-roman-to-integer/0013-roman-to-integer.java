class Solution {
    public int romanToInt(String s) {
       HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans = map.get(s.charAt(s.length() - 1));
        for( int i = s.length() - 2; i >= 0; i--)
        {
            int num = map.get(s.charAt(i));
            if( num < ans && s.charAt(i) != s.charAt(i+1))
            {
                ans = ans - num;
            }
            else
            {
                ans = ans + num;
            }
        }
        return ans;  
    }
}