class Solution {
    public int digitFrequencyScore(int n) {
        int f[] = new int[10];
         while (n > 0) {
            f[n % 10]++;
            n /= 10;
        }

        int sum = 0;

        for (int d = 0; d < 10; d++) {
            sum += d * f[d];
        }
        return sum;
    }
}
        
        
   