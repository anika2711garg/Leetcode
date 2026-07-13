class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        int n = words.length;

        for( int i = n - 1; i>=0; i--)
        {
            result.append(words[i]);
            if( i > 0) 
            result.append(" ");
        }
        return result.toString();

        }
    }