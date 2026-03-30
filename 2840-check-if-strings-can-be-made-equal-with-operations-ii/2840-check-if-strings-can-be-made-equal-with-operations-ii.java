class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
       String s1e = "";
       String s2e = "";
       String s1o = "";
       String s2o = "";
       for( int i = 0; i < n; i++)
       {
       if(i % 2 == 0)
       {
         s1e = s1e + s1.charAt(i);
         s2e = s2e + s2.charAt(i);
       } 
       else
       {
        s1o = s1o +  s1.charAt(i);
        s2o = s2o +  s2.charAt(i);
       }
       }
       char[] a1 = s1e.toCharArray();
        char[] a2 = s2e.toCharArray();
        char[] b1 = s1o.toCharArray();
        char[] b2 = s2o.toCharArray();

         Arrays.sort(a1);
        Arrays.sort(a2);
        Arrays.sort(b1);
        Arrays.sort(b2);

       if (Arrays.equals(a1, a2) && Arrays.equals(b1, b2)) {
            return true;
        } else {
            return false;
        }
    }
}