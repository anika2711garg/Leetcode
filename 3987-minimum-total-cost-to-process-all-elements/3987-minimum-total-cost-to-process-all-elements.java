import java.math.BigInteger;

class Solution {
    public int minimumCost(int[] nums, int k) {

        int[] ans = nums;

        final long MOD = 1_000_000_007L;
        BigInteger mod = BigInteger.valueOf(MOD);

        long resource = k;
        long ops = 0;
        BigInteger cost = BigInteger.ZERO;

        for (int x : ans) {

            if (resource < x) {

                long need = (x - resource + k - 1L) / k;

                BigInteger addCost =
                        BigInteger.valueOf(need)
                                .multiply(BigInteger.valueOf(2 * ops + need + 1))
                                .divide(BigInteger.valueOf(2));

                cost = cost.add(addCost).mod(mod);

                ops += need;
                resource += need * (long) k;
            }

            resource -= x;
        }

        return cost.intValue();
    }
}