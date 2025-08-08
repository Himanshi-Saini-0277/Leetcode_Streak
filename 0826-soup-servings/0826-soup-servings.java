class Solution {
    private Double[][] cache;

    public double soupServings(int n) {
        if (n > 5000) return 1.0;

        int units = (int) Math.ceil(n / 25.0);
        cache = new Double[units + 1][units + 1];

        return calcProb(units, units);
    }

    private double calcProb(int soupA, int soupB) {

        if (soupA <= 0 && soupB <= 0) return 0.5;
        if (soupA <= 0) return 1.0;
        if (soupB <= 0) return 0.0;

        if (cache[soupA][soupB] != null) return cache[soupA][soupB];

        double prob = 0.25 * (
            calcProb(soupA - 4, soupB) +
            calcProb(soupA - 3, soupB - 1) +
            calcProb(soupA - 2, soupB - 2) +
            calcProb(soupA - 1, soupB - 3)
        );

        cache[soupA][soupB] = prob;
        return prob;
    }
}