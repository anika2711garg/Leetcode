class Solution {
    public int maxRotateFunction(int[] a) {
        int n = a.length;
        int s = 0, f = 0;

        for (int i = 0; i < n; i++) {
            s += a[i];
            f += i * a[i];
        }

        int m = f;

        for (int i = n - 1; i > 0; i--) {
            f = f + s - n * a[i];
            m = Math.max(m, f);
        }

        return m;
    }
}