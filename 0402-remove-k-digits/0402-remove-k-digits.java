class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Stack<Integer> st = new Stack<>();
        int cnt = k;
        for(int i = 0; i < num.length(); i++){
            int x = num.charAt(i)-'0';
            while(!st.isEmpty()&&cnt>0&&st.peek()>x){
                st.pop();
                cnt--;
            }
            st.push(x);
        }
        while(!st.isEmpty()&&cnt>0){
            st.pop();
            cnt--;
        }
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while(!sb.isEmpty()&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.isEmpty()) sb.append("0");
        return sb.toString();
    }
}