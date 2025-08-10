class Solution {
    private int[] digitFreq(int n) {
        int[] freq = new int[10];
        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }
        return freq;
    }

    private boolean equalFreq(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    public boolean reorderedPowerOf2(int N) {
        int[] target = digitFreq(N);

        for (int i = 0; i <= 30; i++) {
            int powerof2 = (int) Math.pow(2, i);
            if (equalFreq(target, digitFreq(powerof2)))
                return true;
        }
        return false;
    }
}