class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        String curr = "";
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // if digit
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // if '['
            else if (ch == '[') {
                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = "";
            }

            // if ']'
            else if (ch == ']') {
                int times = numStack.pop();
                String prev = strStack.pop();

                for (int j = 0; j < times; j++) {
                    prev += curr;
                }

                curr = prev;
            }

            else {
                curr += ch;
            }
        }

        return curr;
    }
}
