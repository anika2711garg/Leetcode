class Solution {
    public int maxValue(int[] nums1, int[] nums0) {
        int n=nums1.length;
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<=n-1;i++){
           list.add(segmentformed(nums1[i],nums0[i]));
        }
       Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));
        int a=list.size();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<a;i++){
            sb.append(list.get(i));
        }
      
        int MOD = 1_000_000_007;
        long result = 0;
        for (String s : list) {
            for (int i=0; i < s.length(); i++) {
                result = (result * 2 + (s.charAt(i)-'0')) % MOD;
            }
        }

        return (int)result;
    }
    public String segmentformed(int n,int m){
        StringBuilder sb=new StringBuilder();
        while(n>0){
            sb.append('1');
            n--;
        }
        while(m>0){
            sb.append('0');
            m--;
        }
        return sb.toString();
    }
}