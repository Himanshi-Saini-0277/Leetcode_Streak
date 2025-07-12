public class Solution 
{
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) 
    {
        int p1 = Math.min(firstPlayer, secondPlayer);
        int p2 = Math.max(firstPlayer, secondPlayer);

        if (p1 + p2 == n + 1) 
        {
            return new int[]{1, 1};
        }

        if (n <= 4) 
        {
            return new int[]{2, 2};
        }

        int m = (n + 1) / 2;
        int minRound = Integer.MAX_VALUE;
        int maxRound = Integer.MIN_VALUE;

        if (p1 - 1 > n - p2) 
        {
            int t = n + 1 - p1;
            p1 = n + 1 - p2;
            p2 = t;
        }

        if (p2 * 2 <= n + 1) 
        {
            int a = p1 - 1;
            int b = p2 - p1 - 1;

            for (int i = 0; i <= a; i++) {

                for (int j = 0; j <= b; j++) 
                {
                    int[] next = earliestAndLatest(m, i + 1, i + j + 2);
                    minRound = Math.min(minRound, next[0] + 1);
                    maxRound = Math.max(maxRound, next[1] + 1);
                }
            }
        } 
        else 
        {
            int p4 = n + 1 - p2;
            int a = p1 - 1;
            int b = p4 - p1 - 1;
            int c = p2 - p4 - 1;

            for (int i = 0; i <= a; i++) 
            {
                for (int j = 0; j <= b; j++) 
                {
                    int offset = i + j + 1 + (c + 1) / 2 + 1;
                    int[] next = earliestAndLatest(m, i + 1, offset);
                    minRound = Math.min(minRound, next[0] + 1);
                    maxRound = Math.max(maxRound, next[1] + 1);
                }
            }
        }

        return new int[]{minRound, maxRound};
    }
}