class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] h = Arrays.copyOf(hFences, hFences.length + 2);
        h[hFences.length] = 1;
        h[hFences.length + 1] = m;
        
        int[] v = Arrays.copyOf(vFences, vFences.length + 2);
        v[vFences.length] = 1;
        v[vFences.length + 1] = n;

        Arrays.sort(h);
        Arrays.sort(v);

        Set<Integer> hGaps = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                hGaps.add(h[j] - h[i]);
            }
        }

        long maxSide = -1;
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int currentGap = v[j] - v[i];
                if (hGaps.contains(currentGap)) {
                    maxSide = Math.max(maxSide, currentGap);
                }
            }
        }

        if (maxSide == -1) return -1;

        long MOD = 1_000_000_007;
        return (int) ((maxSide * maxSide) % MOD);
    }
}