class Solution {
    public int numberOfWays(String corridor) {
        long mod = 1000000007;
        long ways = 1;
        int seatCount = 0;
        int n = corridor.length();

        int lastSeatIndex = -1;      // stores the index of previous seat
        boolean firstPairDone = false;

        for (int i = 0; i < n; i++) {
            char c = corridor.charAt(i);

            if (c == 'S') {
                seatCount++;

                // If this is a new pair starting
                if (seatCount % 2 == 1) {
                    // odd number seat -> start of new pair
                    if (lastSeatIndex != -1 && firstPairDone) {
                        // all previous pairs are complete
                        ways = (ways * (i - lastSeatIndex)) % mod;
                    }
                } else {
                    // even seat -> pair completed
                    lastSeatIndex = i;
                    firstPairDone = true;
                }
            }
        }

        // total seats must be even and >= 2
        if (seatCount < 2 || seatCount % 2 == 1) return 0;

        return (int) ways;
    }
}
