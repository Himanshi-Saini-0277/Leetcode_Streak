class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = getRotation(tops, bottoms, tops[0]);
        if (bottoms[0] != tops[0]) {
            res = Math.min(res, getRotation(tops, bottoms, bottoms[0]));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int getRotation(int[] tops, int[] bottoms, int target) {
        int rotateTop = 0, rotateBottom = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return Integer.MAX_VALUE;
            }
            if (tops[i] != target) rotateTop++;
            if (bottoms[i] != target) rotateBottom++;
        }
        return Math.min(rotateTop, rotateBottom);
    }
}