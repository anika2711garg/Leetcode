class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        int mindiff = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int diff = A[i] - A[i - 1];
            if (diff < mindiff) {
                mindiff = diff;
                res = new ArrayList<>();
                res.add(Arrays.asList(A[i - 1], A[i]));
            } else if (diff == mindiff) {
                res.add(Arrays.asList(A[i - 1], A[i]));
            }
        }

        return res;
    }
}
