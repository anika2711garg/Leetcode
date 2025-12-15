class Solution {
    public int numberOfWays(String corridor) {
        long mod = 1000000007;
        long ways = 1;

        int seats = 0;     
        int last = -1;     
        int n = corridor.length();

        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                seats++;

                if (seats >= 3 && seats % 2 == 1) {
                    ways = (ways * (i - last)) % mod;
                }

                last = i;
            }
        }

        if (seats == 0 || seats % 2 == 1) return 0;

        return (int) ways;
    }
}
