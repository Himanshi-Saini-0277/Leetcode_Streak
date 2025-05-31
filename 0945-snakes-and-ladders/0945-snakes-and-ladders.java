class Solution {
    public int snakesAndLadders(int[][] board) {
        int size = board.length;
        int target = size * size;

        short[] flattened = new short[target + 1];
        int index = 1;

        for (int row = size - 1; row >= 0; row--) {
            for (int col = 0; col < size; col++) {
                flattened[index++] = (short) board[row][col];
            }
            if (--row < 0) break;
            for (int col = size - 1; col >= 0; col--) {
                flattened[index++] = (short) board[row][col];
            }
        }

        short[] queue = new short[target];
        int head = 0, tail = 0;
        queue[tail++] = 1;

        int[] steps = new int[target + 1];
        steps[1] = 1;

        while (head != tail) {
            int position = queue[head++];
            head %= target;

            if (position + 6 >= target) {
                return steps[position];
            }

            int maxNeutral = 0;
            for (int roll = 6; roll >= 1; roll--) {
                int next = position + roll;

                if (flattened[next] >= 0) {
                    next = flattened[next];
                    if (next == target) return steps[position];
                } else {
                    if (roll < maxNeutral) continue;
                    maxNeutral = roll;
                }

                if (steps[next] == 0) {
                    steps[next] = steps[position] + 1;
                    queue[tail++] = (short) next;
                    tail %= target;

                    if (head == tail) return 0;
                }
            }
        }

        return -1;
    }
}

