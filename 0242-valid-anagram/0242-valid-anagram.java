class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ar1 = s.toCharArray();
        char[] ar2 = t.toCharArray();
        if( ar1.length != ar2.length)
        {
            return false;
        }
        Arrays.sort(ar1);
        Arrays.sort(ar2);
        return Arrays.equals(ar1,ar2);
    }
}