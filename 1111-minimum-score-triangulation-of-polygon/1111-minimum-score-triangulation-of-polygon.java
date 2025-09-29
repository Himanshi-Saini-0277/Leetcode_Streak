class Solution {
    public int minScoreTriangulation(int[] polygonValues) {
        int vertexCount = polygonValues.length;
        int[][] minScore = new int[vertexCount][vertexCount];

        for (int gap = 2; gap < vertexCount; gap++) {
            for (int start = 0; start + gap < vertexCount; start++) {
                int end = start + gap;
                int currentMinScore = Integer.MAX_VALUE;

                for (int mid = start + 1; mid < end; mid++) {
                    int triangleScore = minScore[start][mid] 
                        + minScore[mid][end] 
                        + polygonValues[start] * polygonValues[mid] * polygonValues[end];
                    currentMinScore = Math.min(currentMinScore, triangleScore);
                }
                minScore[start][end] = currentMinScore;
            }
        }
        return minScore[0][vertexCount - 1];
    }

   
}